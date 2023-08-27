package com.rp.sec2;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {
        Flux.range(2, 10)
                .log()
                .map(i -> Utils.faker().name().fullName())
                .log()
                .subscribe(Utils.onNext());
    }
}
