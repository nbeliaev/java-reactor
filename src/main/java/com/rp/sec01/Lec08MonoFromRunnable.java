package com.rp.sec01;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProccess())
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }

    private static Runnable timeConsumingProccess() {
        return () -> {
            Utils.sleepSeconds(3);
            System.out.println("Op completed");
        };
    }
}
