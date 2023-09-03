package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class Lec06ScenarionNameTest {

    @Test
    void test1() {
        Flux<String> flux = Flux.just("a", "b", "c");

        StepVerifierOptions name = StepVerifierOptions.create().scenarioName("ABC test");

        StepVerifier.create(flux, name)
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void test2() {
        Flux<String> flux = Flux.just("a", "b", "c");

        StepVerifier.create(flux)
                .expectNext("a")
                .as("a-test")
                .expectNext("b")
                .as("b-test")
                .expectNext("d")
                .as("d-test")
                .verifyComplete();
    }
}
