package com.rp.sec08;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Assignment {

    public static void main(String[] args) {
        int price = 10000;
        Flux.combineLatest(monthStream(), demandStream(), (m, d) -> (price - (m * 100)) * d)
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(20);
    }

    private static Flux<Long> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Utils.faker().random().nextInt(80, 120) / 100d)
                .startWith(1d);
    }
}
