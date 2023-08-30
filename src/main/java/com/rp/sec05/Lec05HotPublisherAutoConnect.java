package com.rp.sec05;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublisherAutoConnect {

    public static void main(String[] args) {
        // cache = publish().replay() up to int.max
        Flux<String> movieStream = Flux.fromStream(Lec05HotPublisherAutoConnect::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .cache();

        movieStream.subscribe(Utils.subscriber("sam"));

        Utils.sleepSeconds(5);

        movieStream.subscribe(Utils.subscriber("mike"));

        Utils.sleepSeconds(20);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10");
    }
}
