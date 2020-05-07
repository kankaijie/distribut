package com.org.atomikos.mapper.ds1;

import com.org.atomikos.config.BaseMapper;
import com.org.atomikos.entity.ds1.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PayMapper extends BaseMapper<Pay,Integer> {
}
