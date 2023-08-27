package com.rp.sec03;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Utils.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada"));
                    fluxSink.complete();
                })
                .subscribe(Utils.subscriber());
    }
}
