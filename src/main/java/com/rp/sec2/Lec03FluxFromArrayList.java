package com.rp.sec2;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayList {

    public static void main(String[] args) {
        List<String> strings = List.of("a", "b", "c");

        Flux.fromIterable(strings)
                .subscribe(Utils.onNext());
    }
}
