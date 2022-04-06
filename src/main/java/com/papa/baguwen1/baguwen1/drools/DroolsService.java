package com.papa.baguwen1.baguwen1.drools;


import org.kie.api.KieBase;
import org.springframework.stereotype.Service;

import static com.papa.baguwen1.baguwen1.drools.NewKieBase.rulekieBase;


@Service
public class DroolsService {
    /**
     * 创建KieSession
     * @return
     */
    public KieBase newKieBase(String rule) {
        KieBase kieBase = rulekieBase(rule);
        return kieBase;
    }
}
