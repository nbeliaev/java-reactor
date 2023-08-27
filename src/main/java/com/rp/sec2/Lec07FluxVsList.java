package com.rp.sec2;

import com.rp.sec2.helper.NameGenerator;
import com.rp.util.Utils;
import jdk.jshell.execution.Util;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {
        /*List<String> names = NameGenerator.getNames(5);
        System.out.println(names);*/
        NameGenerator.getNames(5)
                .subscribe(Utils.onNext());
    }
}
