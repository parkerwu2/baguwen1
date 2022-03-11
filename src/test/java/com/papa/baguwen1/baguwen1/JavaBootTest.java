package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.importor.TestA;
import com.papa.baguwen1.baguwen1.importor.TestB;
import com.papa.baguwen1.baguwen1.importor.TestC;
import com.papa.baguwen1.baguwen1.importor.TestD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JavaBootTest {
    @Autowired
    private TestA testA;
    @Autowired
    private TestB testB;
    @Autowired
    private TestC testC;
    @Autowired
    private TestD testD;

    @Test
    public void test(){
        testA.printName();
        testB.printName();
        testC.printName();
        testD.printName();
    }
}
