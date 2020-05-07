package com.org.atomikos.entity.ds2;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Table(name = "logs_info")
public class LogsInfo implements Serializable {
    private static final long serialVersionUID = 6274088162162555073L;

    @Id
    private Integer id;


    private Date createTime;
    private String content;
}
