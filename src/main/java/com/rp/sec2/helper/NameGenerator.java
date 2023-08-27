package com.rp.sec2.helper;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }
    /*public static List<String> getNames(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }*/

    private static String getName() {
        Utils.sleepSeconds(1);
        return Utils.faker().name().fullName();
    }
}
