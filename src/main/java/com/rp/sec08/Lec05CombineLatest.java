package com.rp.sec08;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05CombineLatest {

    public static void main(String[] args) {
        Flux.combineLatest(getString(), getNumber(), (s, i) -> s + i)
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
    }

    private static Flux<String> getString() {
        return Flux.just("a", "b", "c", "d")
                .delayElements(Duration.ofSeconds(1));
    }

    private static Flux<Integer> getNumber() {
        return Flux.just(1, 2, 3, 4)
                .delayElements(Duration.ofSeconds(3));
    }
}
