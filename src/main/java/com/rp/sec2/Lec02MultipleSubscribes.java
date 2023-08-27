package com.rp.sec2;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribes {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        flux.subscribe(i -> System.out.println("Sub 1: " + i));
        flux.filter(i -> i % 2 == 0).subscribe(i -> System.out.println("Sub 2: " + i));
    }
}
