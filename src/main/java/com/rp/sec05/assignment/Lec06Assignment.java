package com.rp.sec05.assignment;

import com.rp.util.Utils;

public class Lec06Assignment {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // revenue and inventory observe the order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream().subscribe(Utils.subscriber("inventory"));
        revenueService.revenueStream().subscribe(Utils.subscriber("revenue"));

        Utils.sleepSeconds(60);
    }
}
