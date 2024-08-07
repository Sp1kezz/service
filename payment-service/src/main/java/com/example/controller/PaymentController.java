package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.feignclient.AccountFeignClient;
import com.example.handler.SentinelResourceExceptionHandler;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private Environment environment;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private PaymentService paymentService;
    @Transactional
    @GetMapping("/pay/{id}")
    @SentinelResource(value = "pay", blockHandlerClass = SentinelResourceExceptionHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = SentinelResourceExceptionHandler.class,
            fallback = "fallback")
    public String pay(@PathVariable("id") String accountId) {
        String payResult = accountFeignClient.reduce(accountId);
        boolean flag = paymentService.pay(accountId);
        String serverPort = environment.getProperty("server.port");
        return payResult + " 支付服务端口：" + serverPort;
    }
}