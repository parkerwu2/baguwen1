package com.papa.baguwen1.baguwen1.importor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class SelfImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.papa.baguwen1.baguwen1.importor.TestC"};
    }
}
