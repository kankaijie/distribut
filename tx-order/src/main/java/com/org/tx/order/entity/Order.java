package com.org.tx.order.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table(name = "order")
public class Order {

    @Id
    private Integer id;
    private Integer status;
}
