package com.rp.sec2;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
        /*Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        doSmth(flux);
        flux.subscribe(Utils.onNext());*/

        Flux.range(0, 10)
                .filter(i -> i > 3)
                .next() // same as stream().findFirst()
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }

    private static void doSmth(Flux<String> flux) {

    }
}
