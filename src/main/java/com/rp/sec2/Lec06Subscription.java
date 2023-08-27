package com.rp.sec2;

import com.rp.util.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete: ");
                    }
                });

        Utils.sleepSeconds(3);
        atomicReference.get().request(3);
        Utils.sleepSeconds(3);
        atomicReference.get().request(3);
        Utils.sleepSeconds(3);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Utils.sleepSeconds(3);
        atomicReference.get().request(4);
    }
}
