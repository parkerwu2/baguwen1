package com.papa.baguwen1.baguwen1.drools.drool;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rule/person")
public class PersonRuleController {

    @Autowired
    private KieContainer kieContainer;

    @PostMapping("one")
    public void fireAllRules4One(@RequestBody Person person) {
        KieSession kSession = kieContainer.newKieSession();
        try {
            kSession.insert(person);
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
    }

    @PostMapping("list")
    public void fireAllRules4List(@RequestBody List<Person> persons) {
        KieSession kSession = kieContainer.newKieSession();
        try {
            for (Person person : persons) {
                kSession.insert(person);
            }
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
    }
}
