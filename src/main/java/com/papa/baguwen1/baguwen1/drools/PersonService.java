package com.papa.baguwen1.baguwen1.drools;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Resource
    private DroolsService droolsService;

    public List<Person> listPerson(){
        String rule = RuleExecute.activityRule();
        KieBase kieBase=droolsService.newKieBase(rule);
        Person one = new Person();
        one.setAge("22");
        one.setName("张三");
        Person two = new Person();
        two.setAge("23");
        two.setName("张三");
        List<Person> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        for(Person person:list){
            KieSession kieSession= kieBase.newKieSession();
            kieSession.insert(person);
            int i=kieSession.fireAllRules();
            kieSession.dispose();
        }
        return list;
    }
}
