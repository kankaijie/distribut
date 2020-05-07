package com.org.atomikos.mapper.ds2;


import com.org.atomikos.config.BaseMapper;
import com.org.atomikos.entity.ds2.LogsInfo;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface LogsInfoMapper extends BaseMapper<LogsInfo,Integer> {


}
