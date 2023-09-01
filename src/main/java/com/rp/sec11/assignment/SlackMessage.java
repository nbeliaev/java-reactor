package com.rp.sec11.assignment;


import lombok.Data;

@Data
public class SlackMessage {

    private static final String FORMAT = "[%s -> %s] : %s";
    private String senderName;
    private String receiverName;
    private String message;

    @Override
    public String toString() {
        return String.format(FORMAT, this.senderName, this.receiverName, this.message);
    }
}
