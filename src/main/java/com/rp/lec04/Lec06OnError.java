package com.rp.lec04;

import com.rp.util.Utils;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                //.onErrorReturn(-1)
                //.onErrorResume(e -> fallback())
                .onErrorContinue((err, obj) -> {

                })
                .subscribe(Utils.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Utils.faker().random().nextInt(100, 200));
    }
}
