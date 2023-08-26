package com.rp.sec01;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {
        // use just only when you have data
        //Mono<String> mono = Mono.just(getName());

        Mono<String> mono1 = Mono.fromSupplier(Lec05MonoFromSupplier::getName);
        mono1.subscribe(Utils.onNext());

        Mono<String> mono2 = Mono.fromCallable(Lec05MonoFromSupplier::getName);
        mono2.subscribe(Utils.onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Utils.faker().name().fullName();
    }
}
