package com.rp.lec04;

import com.rp.lec04.helper.Person;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec10Transofrm {

    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
                .subscribe(Utils.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Too yong"));
    }
}
