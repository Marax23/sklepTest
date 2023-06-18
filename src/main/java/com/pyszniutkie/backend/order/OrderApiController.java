package com.pyszniutkie.backend.order;

import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderApiController {

    private OrderApiService orderApiService;

    public OrderApiController(OrderApiService orderApiService) {
        this.orderApiService = orderApiService;
    }

    @PostMapping("/api/orders")
    public Bill saveDishOrder(@RequestBody Map<Integer, Integer> order) {
        System.out.println("On Backend controller reviced: " + order);
        return orderApiService.saveDishOrder(order);
    }

    @PostMapping("/api/orders/{orderId}/address")
    public Bill addAddress(@PathVariable int orderId, @RequestBody Address address) {
       return orderApiService.addAddress(orderId, address);
    }
}
