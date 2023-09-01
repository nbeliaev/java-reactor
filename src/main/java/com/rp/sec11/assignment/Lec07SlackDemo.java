package com.rp.sec11.assignment;

import com.rp.util.Utils;

public class Lec07SlackDemo {

    public static void main(String[] args) {
        SlackRoom slackRoom = new SlackRoom("reactor");
        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi all");
        Utils.sleepSeconds(4);

        jake.says("Hey");
        sam.says("I simply wanted to say hi...");
        Utils.sleepSeconds(4);

        slackRoom.joinRoom(mike);
        mike.says("Hey guys");
    }
}
