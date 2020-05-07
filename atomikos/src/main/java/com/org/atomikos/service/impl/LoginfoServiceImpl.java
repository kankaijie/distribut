package com.org.atomikos.service.impl;

import com.org.atomikos.entity.ds2.LogsInfo;
import com.org.atomikos.mapper.ds2.LogsInfoMapper;
import com.org.atomikos.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginfoServiceImpl implements LogInfoService {

    @Autowired
    private LogsInfoMapper logInfoMapper;

    @Override
    public void add(LogsInfo logInfo) {
        logInfoMapper.insert(logInfo);
    }

    @Override
    public List<LogsInfo> getAll() {
      List<LogsInfo>  logInfos=logInfoMapper.selectAll();
      return logInfos;
    }
}
