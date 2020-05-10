package com.org.tx.pay.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;


@Configuration
@RegisterMapper
public interface BaseMapper<T, PK> extends Mapper<T>,IdListMapper<T, PK>, InsertListMapper<T> {
}
