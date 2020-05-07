package com.org.atomikos.entity.ds1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table(name = "order")
public class Order {

    @Id
    private Integer id;
    private Integer status;
}
