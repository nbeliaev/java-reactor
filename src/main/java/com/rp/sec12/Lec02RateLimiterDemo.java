package com.rp.sec12;

import com.rp.sec12.helper.BookService;
import com.rp.sec12.helper.UserService;
import com.rp.util.Utils;
import reactor.util.context.Context;

public class Lec02RateLimiterDemo {

    public static void main(String[] args) {
        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Utils.subscriber());
    }
}
