package com.hgx.springcloud.order.entities;

import lombok.Data;

@Data
public class Payment {


    private Integer id;

    /**
    * 流水号
    */
    private String serial;
}