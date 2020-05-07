package com.org.atomikos.service;


import com.org.atomikos.entity.ds2.LogsInfo;


import java.util.List;


public interface LogInfoService {

    public void add(LogsInfo logInfo);

    public List<LogsInfo> getAll();
}
