package com.rp.sec03.assigment;

import com.rp.util.Utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        readerService.read(path)
                .take(2)
                .subscribe(Utils.subscriber());
    }
}
