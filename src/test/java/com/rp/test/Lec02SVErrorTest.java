package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02SVErrorTest {

    @Test
    void test1() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Object> error = Flux.error(new RuntimeException("oops"));
        Flux<Object> concat = Flux.concat(just, error);
        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyError();
    }

    @Test
    void test2() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Object> error = Flux.error(new RuntimeException("oops"));
        Flux<Object> concat = Flux.concat(just, error);
        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyError(RuntimeException.class);
    }

    @Test
    void test3() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Object> error = Flux.error(new RuntimeException("oops"));
        Flux<Object> concat = Flux.concat(just, error);
        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyErrorMessage("oops");
    }
}
