package com.rp.sec01;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(1)
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        userRepository(2)
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        userRepository(20)
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Utils.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); //null
        } else {
            return Mono.error(new RuntimeException("Invalid user id"));
        }
    }
}
