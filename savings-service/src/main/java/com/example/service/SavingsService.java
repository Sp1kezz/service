package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.domain.Savings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SavingsService {

    public boolean deduct(String productId) {
        Savings savings = new Savings();
        QueryWrapper<Savings> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", productId);
        Savings stk = savings.selectOne(queryWrapper);
        if (stk != null) {
            Integer count = stk.getCount() - 10;
            stk.setCount(count);
            stk.updateById();
            return true;
        }
        return false;
    }
}
