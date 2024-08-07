package com.example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//声明Feign客户端,调用stock-service微服务
@FeignClient(name = "savings-service")
public interface SavingsFeignClient {

    //调用deduct方法:http://[stock-service address]/stock/deduct/{id}
    @GetMapping("/savings/deduct/{id}")
    public String deduct(@PathVariable("id") String productId);
}
