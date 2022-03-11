package com.papa.baguwen1.baguwen1.importor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//加上@Configuration是为了能让Spring 扫描到这个类，并且直接通过@Import引入TestA类
@Import({TestA.class, SelfImportSelector.class, SelfImportBeanDefinitionRegistrar.class})
@Configuration
public class ImportConfig {
}
