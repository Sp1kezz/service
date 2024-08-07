package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class PaymentService {
    public boolean pay(String accountId) {
        return true;
    }
}
