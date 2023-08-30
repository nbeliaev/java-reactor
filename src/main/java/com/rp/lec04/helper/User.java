package com.rp.lec04.helper;

import com.rp.util.Utils;
import lombok.Data;

@Data
public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = Utils.faker().name().fullName();
    }
}
