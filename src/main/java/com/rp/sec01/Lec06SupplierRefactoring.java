package com.rp.sec01;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        //run async an the current thread will not wait
        //getName()
        //        .subscribeOn(Schedulers.boundedElastic()) //to do not block the current thread
        //        .subscribe(Utils.onNext());

        String s = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block(); //use this only for test purposes
        System.out.println(s);

        getName();
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Utils.sleepSeconds(3);
            return Utils.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
