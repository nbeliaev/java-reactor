package com.rp.sec03;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerator {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("emitting");
                    synchronousSink.next(Utils.faker().country().name());
                })
                .take(2)
                .subscribe(Utils.subscriber());
    }
}
