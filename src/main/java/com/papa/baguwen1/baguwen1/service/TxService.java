package com.papa.baguwen1.baguwen1.service;

import com.papa.baguwen1.baguwen1.dao.mapper.Ba1Mapper;
import com.papa.baguwen1.baguwen1.dao.pojo.Ba1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TxService {
    @Autowired
    private Ba1Mapper ba1Mapper;

    @Transactional
    public void doTxTest(){
        try {
            Ba1 ba1 = new Ba1();
            ba1.setCreateTime(new Date());
            ba1.setUpdateTime(new Date());
            ba1.setStock(100);
            ba1Mapper.insertSelective(ba1);
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println("txtest service error");
        }

    }
}
