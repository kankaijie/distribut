package com.org.tx.pay.mapper;



import com.org.tx.pay.config.BaseMapper;
import com.org.tx.pay.entity.LogsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface LogsInfoMapper extends BaseMapper<LogsInfo,Integer> {


}
