package com.rp.sec01.assignment;

import com.rp.util.Utils;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        FileService.write("file03.txt", "This is file03")
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        FileService.delete("file04.txt")
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
