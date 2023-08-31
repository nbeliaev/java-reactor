package com.rp.sec06;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;

public class Lec06Parallel {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next " + i))
                .subscribe(v -> printThreadName("sub " + v));

        Utils.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t" + Thread.currentThread().getName());
    }
}
