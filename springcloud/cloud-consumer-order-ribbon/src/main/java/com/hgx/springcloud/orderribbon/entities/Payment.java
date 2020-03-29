package com.hgx.springcloud.orderribbon.entities;

import lombok.Data;

@Data
public class Payment {


    private Integer id;

    /**
    * 流水号
    */
    private String serial;
}