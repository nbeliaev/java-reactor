package com.rp.sec2;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        Flux<Integer> flux = Flux.fromStream(stream);
        flux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        flux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
