package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec01SvDemoTest {

    @Test
    void test1() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        StepVerifier.create(just)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }

    @Test
    void test2() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        StepVerifier.create(just)
                .expectNext(1, 2, 3)
                .verifyComplete();
    }
}
