package com.hgx.springcloud.payment.dao;

import com.hgx.springcloud.payment.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getById(@Param("id")Integer id);





}