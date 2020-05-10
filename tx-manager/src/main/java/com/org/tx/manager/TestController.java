package com.org.tx.manager;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/get")
    @LcnTransaction
    public void get(){
        int i=10/0;
    }
}
