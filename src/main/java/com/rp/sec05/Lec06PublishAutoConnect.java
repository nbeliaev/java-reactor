package com.rp.sec05;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec06PublishAutoConnect {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(Lec06PublishAutoConnect::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Utils.sleepSeconds(3);

        movieStream.subscribe(Utils.subscriber("sam"));

        Utils.sleepSeconds(5);

        System.out.println("Mike is joining");

        movieStream.subscribe(Utils.subscriber("mike"));

        Utils.sleepSeconds(20);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10");
    }
}
