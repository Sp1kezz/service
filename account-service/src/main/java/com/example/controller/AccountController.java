package com.example.controller;

import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Transactional
    @GetMapping("/reduce/{id}")
    public String reduce(@PathVariable("id") String accountId) {
        boolean flag = accountService.reduce(accountId);
        return "用户账户：" + accountId + "，支付成功!";
    }
}