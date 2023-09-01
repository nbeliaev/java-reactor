package com.rp.sec10;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class Lec04RetryWhenAdvanced {


    public static void main(String[] args) {
        orderService(Utils.faker().business().creditCardNumber())
                .doOnError(err -> System.out.println(err.getMessage()))
                .retryWhen(Retry.from(flux ->
                        flux.doOnNext(rs -> {
                                    System.out.println(rs.totalRetries());
                                    System.out.println(rs.failure());
                                })
                                .handle((rs, syncSink) -> {
                                    if (rs.failure().getMessage().equals("500")) {
                                        syncSink.next(1);
                                    } else {
                                        syncSink.error(rs.failure());
                                    }
                                })
                                .delayElements(Duration.ofSeconds(1))))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return Utils.faker().idNumber().valid();
        });
    }

    private static void processPayment(String ccNumber) {
        int random = Utils.faker().random().nextInt(1, 10);
        if (random < 8) {
            throw new RuntimeException("500");
        } else if (random < 10) {
            throw new RuntimeException("404");
        }
    }
}
