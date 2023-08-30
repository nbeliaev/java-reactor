package com.rp.lec04.helper;

import com.rp.util.Utils;
import jdk.jshell.execution.Util;
import lombok.Data;

@Data
public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = Utils.faker().name().firstName();
        this.age = Utils.faker().random().nextInt(1, 30);
    }
}
