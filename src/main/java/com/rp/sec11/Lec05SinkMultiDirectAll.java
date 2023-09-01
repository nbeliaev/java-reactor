package com.rp.sec11;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05SinkMultiDirectAll {

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");

        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing(); //without buffering events

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Utils.subscriber("sam"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(Utils.subscriber("mike"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Utils.sleepSeconds(10);
    }
}
