package com.rp.lec04;

import com.rp.lec04.helper.OrderService;
import com.rp.lec04.helper.UserService;
import com.rp.util.Utils;

public class Lec12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Utils.subscriber());
    }
}
