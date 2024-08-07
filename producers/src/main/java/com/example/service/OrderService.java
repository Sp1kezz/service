package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public boolean confirmStatus(String orderId) {
        Order order = new Order();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", orderId);
        Order ord = order.selectOne(queryWrapper);
        if (ord != null) {
            ord.setStatus(true);
            ord.updateById();
            return true;
        }
        return false;
    }
}