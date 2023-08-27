package com.rp.sec2;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux<Integer> just = Flux.just(1, 2, 3);
        just.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
