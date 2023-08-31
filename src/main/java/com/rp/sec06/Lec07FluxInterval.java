package com.rp.sec06;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)) //internally uses parallel
                .subscribe(Utils.subscriber());
    }
}
