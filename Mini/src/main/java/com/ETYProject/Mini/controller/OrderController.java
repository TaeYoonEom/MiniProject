package com.ETYProject.Mini.controller;

import com.ETYProject.Mini.entity.Order;
import com.ETYProject.Mini.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestParam Long product_id, @RequestParam Long orderCount){
        return orderService.createOrder(product_id, orderCount);
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }
}
