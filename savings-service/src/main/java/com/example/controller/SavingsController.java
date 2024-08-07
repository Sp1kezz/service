package com.example.controller;

import com.example.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savings")
public class SavingsController {
    @Autowired
    private SavingsService savingsService;

    @GetMapping("/deduct/{id}")
    public String deduct(@PathVariable("id") String productId) {
        boolean flag = savingsService.deduct(productId);
        return "商品编号：" + productId + "，购买成功！";
    }
}