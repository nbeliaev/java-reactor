package com.rp.sec03;

import com.rp.sec03.helper.NameProducer;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.push(nameProducer) //not thread safe
                .subscribe(Utils.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
