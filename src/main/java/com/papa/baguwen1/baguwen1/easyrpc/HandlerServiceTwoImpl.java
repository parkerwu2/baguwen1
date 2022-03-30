package com.papa.baguwen1.baguwen1.easyrpc;

public class HandlerServiceTwoImpl implements HandlerServiceTwo {
    @Override
    public String handleTwo(String mes) {
        return "*****" + mes + "*****";
    }
}
