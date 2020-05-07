package com.org.atomikos.entity.ds1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table(name = "pay")
public class Pay {



    @Id
    private Integer id;
    private Integer status;
}
