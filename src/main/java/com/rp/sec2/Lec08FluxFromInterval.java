package com.rp.sec2;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxFromInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Utils.onNext());

        Utils.sleepSeconds(5);
    }
}
