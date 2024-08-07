package com.example.controller;

import com.example.feignclient.PaymentFeignClient;
import com.example.feignclient.SavingsFeignClient;
import com.example.service.TreasuryService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasury")
@RefreshScope
public class TreasuryController {
    @Autowired
    private Environment environment;
    @Qualifier("com.example.feignclient.PaymentFeignClient")
    @Autowired
    private PaymentFeignClient paymentFeignClient;
    @Autowired
    private SavingsFeignClient savingsFeignClient;
    @Autowired
    private TreasuryService treasuryService;

    @GetMapping("/configs")
    public String getConfigInfo() {
        String serverPort = environment.getProperty("server.port");
        //同一个微服务不同环境之间的共享配置
        String serviceShared = environment.getProperty("config.serviceshared");
        //同组中所有微服务的共享配置
        String allShared = environment.getProperty("config.allshared");
        return "服务端口：" + serverPort + " 共享配置：" + serviceShared + " / " + allShared;
    }

    @GetMapping("/purchase/{pid}/{aid}")
    @GlobalTransactional
    public String purchase(@PathVariable("pid") String productId, @PathVariable("aid") String accountId) {
        String deductResult = savingsFeignClient.deduct(productId);
        String payResult = paymentFeignClient.pay(accountId);
        boolean flag = treasuryService.purchase(productId, accountId);
        return deductResult + payResult;
    }
}