package com.rp.sec08.helper;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AmericanAirlines {

    public static Flux<String> getFlights() {
        return Flux.range(1, Utils.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "American " + Utils.faker().random().nextInt(100, 999))
                .filter(i -> Utils.faker().random().nextBoolean());
    }
}
