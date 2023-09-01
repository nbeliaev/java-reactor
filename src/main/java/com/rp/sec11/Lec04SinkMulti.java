package com.rp.sec11;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();


        sink.tryEmitNext("Hi");
        sink.tryEmitNext("How are you");

        flux.subscribe(Utils.subscriber("sam"));
        flux.subscribe(Utils.subscriber("mike"));

        sink.tryEmitNext("?");

        flux.subscribe(Utils.subscriber("jane"));
        sink.tryEmitNext("really?");
    }
}
