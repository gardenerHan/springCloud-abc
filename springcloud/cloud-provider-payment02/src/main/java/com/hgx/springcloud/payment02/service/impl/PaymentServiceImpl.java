package com.hgx.springcloud.payment02.service.impl;

import com.hgx.springcloud.payment02.dao.PaymentMapper;
import com.hgx.springcloud.payment02.entities.Payment;
import com.hgx.springcloud.payment02.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper ;


    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getById(Integer id) {
        return paymentMapper.getById(id);
    }
}
