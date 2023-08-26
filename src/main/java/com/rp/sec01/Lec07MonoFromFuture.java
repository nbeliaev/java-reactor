package com.rp.sec01;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Utils.onNext());
        Utils.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Utils.faker().name().fullName());
    }
}
