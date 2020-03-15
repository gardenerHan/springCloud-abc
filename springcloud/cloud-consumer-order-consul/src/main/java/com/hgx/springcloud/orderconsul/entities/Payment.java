package com.hgx.springcloud.orderconsul.entities;

import lombok.Data;

@Data
public class Payment {


    private Integer id;

    /**
    * 流水号
    */
    private String serial;
}