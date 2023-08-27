package com.rp.sec03;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGeneratorAssignment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String name = Utils.faker().country().name();
                    System.out.println("emmiting " + name);
                    synchronousSink.next(name);
                    if (name.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Utils.subscriber());
    }
}
