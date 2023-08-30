package com.rp.lec04;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                    System.out.println("----competed");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 " + s))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext" + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 " + s))
                .doOnRequest(l -> System.out.println("doOnRequest " + l))
                .doOnError(err -> System.err.println("doOnError " + err))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doFinally(signal -> System.out.println("doFinally " + signal))
                .subscribe(Utils.subscriber());
    }
}
