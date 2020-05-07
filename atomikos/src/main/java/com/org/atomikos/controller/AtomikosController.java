package com.org.atomikos.controller;

import com.org.atomikos.entity.ds2.LogsInfo;
import com.org.atomikos.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtomikosController {

    @Autowired
    private LogInfoService logInfoService;

    @GetMapping("/getAll")
    public List<LogsInfo>  getAllLogInfo(){
        return logInfoService.getAll();
    }
}
