package com.hgx.springcloud.payment.service;

import com.hgx.springcloud.payment.entities.Payment;

public interface PaymentService {


    int create(Payment payment);

    Payment getById(Integer id);


}
