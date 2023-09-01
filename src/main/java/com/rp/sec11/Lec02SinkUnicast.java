package com.rp.sec11;

import com.rp.util.Utils;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Utils.subscriber("sam"));
        flux.subscribe(Utils.subscriber("mike"));

        sink.tryEmitNext("Hi");
        sink.tryEmitNext("How are you");
        sink.tryEmitNext("?");
    }
}
