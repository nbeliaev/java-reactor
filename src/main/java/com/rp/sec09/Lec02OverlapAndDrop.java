package com.rp.sec09;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02OverlapAndDrop {

    public static void main(String[] args) {
        eventsStream()
                .buffer(3, 1)
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Flux<String> eventsStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event " + i);
    }
}
