package com.rp.sec11.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {

    private String name;
    private Sinks.Many<SlackMessage> sink;
    private Flux<SlackMessage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joinRoom(SlackMember slackMember) {
        System.out.println(slackMember.getName() + "-----" + this.name);
        this.subscribe(slackMember);
        slackMember.setMessageConsumer(msg -> this.postMessage(msg, slackMember));
    }

    private void subscribe(SlackMember slackMember) {
        this.flux
                .filter(sm -> !sm.getSenderName().equals(slackMember.getName()))
                .doOnNext(sm -> sm.setReceiverName(slackMember.getName()))
                .map(SlackMessage::toString)
                .subscribe(slackMember::receives);
    }

    private void postMessage(String message, SlackMember slackMember) {
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setSenderName(slackMember.getName());
        slackMessage.setMessage(message);
        this.sink.tryEmitNext(slackMessage);
    }
}
