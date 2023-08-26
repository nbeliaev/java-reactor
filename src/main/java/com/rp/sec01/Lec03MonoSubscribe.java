package com.rp.sec01;

import com.rp.util.Utils;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        mono.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
