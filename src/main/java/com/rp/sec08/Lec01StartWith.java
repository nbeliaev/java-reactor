package com.rp.sec08;

import com.rp.sec08.helper.NameGenerator;
import com.rp.util.Utils;

public class Lec01StartWith {

    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Utils.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Utils.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(Utils.subscriber("jane"));

        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(1)
                .subscribe(Utils.subscriber("John"));
    }
}
