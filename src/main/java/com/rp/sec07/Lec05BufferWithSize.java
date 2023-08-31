package com.rp.sec07;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05BufferWithSize {

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                    }
                    fluxSink.complete();
                })
                .onBackpressureBuffer(50, o -> System.out.println("Dropped: " + o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Utils.sleepMillis(10))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
    }
}
