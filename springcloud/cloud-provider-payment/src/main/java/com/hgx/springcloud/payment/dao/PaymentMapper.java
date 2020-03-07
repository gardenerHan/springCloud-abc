package com.hgx.springcloud.payment.dao;
import org.apache.ibatis.annotations.Param;

import com.hgx.springcloud.payment.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getById(@Param("id")Integer id);





}