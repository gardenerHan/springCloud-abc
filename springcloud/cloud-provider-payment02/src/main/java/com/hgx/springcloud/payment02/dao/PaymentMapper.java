package com.hgx.springcloud.payment02.dao;

import com.hgx.springcloud.payment02.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getById(@Param("id")Integer id);





}