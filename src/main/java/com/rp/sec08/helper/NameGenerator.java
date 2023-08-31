package com.rp.sec08.helper;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(stringSynchronousSink -> {
                    System.out.println("Generated fresh");
                    Utils.sleepSeconds(1);
                    String name = Utils.faker().name().firstName();
                    list.add(name);
                    stringSynchronousSink.next(name);
                })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}
