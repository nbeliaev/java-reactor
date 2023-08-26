package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        //Publisher
        Mono<Integer> mono = Mono.just(1);

        //Nothing happens until subscribe
        System.out.println(mono);

        mono.subscribe(System.out::println);
    }
}
