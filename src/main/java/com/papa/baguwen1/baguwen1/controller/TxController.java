package com.papa.baguwen1.baguwen1.controller;

import com.papa.baguwen1.baguwen1.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TxController {
    @Autowired
    private TxService txService;

    @RequestMapping("/txInsert")
    public String doTxTest(){
        try {
            txService.doTxTest();
        } catch (Exception e){
            System.out.println("doTxTest failed" + e);
            return "error";
        }
        return "ok";
    }
}
