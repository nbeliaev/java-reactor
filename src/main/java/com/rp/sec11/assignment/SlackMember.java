package com.rp.sec11.assignment;

import lombok.Getter;

import java.util.function.Consumer;

public class SlackMember {

    @Getter
    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

    void receives(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        this.messageConsumer.accept(message);
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
}
