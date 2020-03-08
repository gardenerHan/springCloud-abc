package com.hgx.springcloud.payment02.service;

import com.hgx.springcloud.payment02.entities.Payment;

public interface PaymentService {


    int create(Payment payment);

    Payment getById(Integer id);


}
