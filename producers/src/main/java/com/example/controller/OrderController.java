package com.example.controller;

import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/confirmStatus/{id}")
    public String confirmStatus(@PathVariable("id") String orderId) {
        boolean flag = orderService.confirmStatus(orderId);
        return "订单号：" + orderId + "，支付完成！";
    }
}