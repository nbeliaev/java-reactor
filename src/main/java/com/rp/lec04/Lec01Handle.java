package com.rp.lec04;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {
        //handle = filter + map
        Flux.range(1, 20)
                .handle((item, synchronousSink) -> {
                    if (item % 2 == 0) {
                        synchronousSink.next(item);
                    } else {
                        synchronousSink.next(item + "a");
                    }
                })
                .subscribe(Utils.subscriber());
    }
}
