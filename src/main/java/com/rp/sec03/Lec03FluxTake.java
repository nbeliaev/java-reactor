package com.rp.sec03;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3) // cancel subscription
                .log()
                .subscribe(Utils.subscriber());
    }
}
