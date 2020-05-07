package com.org.atomikos.entity.ds1;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Table(name = "order_info")
public class OrderInfo {

    @Id
    private Integer id;
    private BigDecimal Money;
    private Integer userId;
    private String address;
    private Date createTime;
}
