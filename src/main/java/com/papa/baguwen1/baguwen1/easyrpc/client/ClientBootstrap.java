package com.papa.baguwen1.baguwen1.easyrpc.client;

import com.papa.baguwen1.baguwen1.easyrpc.HandlerServiceOne;
import com.papa.baguwen1.baguwen1.easyrpc.HandlerServiceTwo;

public class ClientBootstrap {
    public static void main(String[] args) {
        //创建代理对象
        HandlerServiceOne handlerServiceOne = new ClientFactory<>(HandlerServiceOne.class).getBean();
        HandlerServiceTwo handlerServiceTwo = new ClientFactory<>(HandlerServiceTwo.class).getBean();
        //通过代理对象调用服务提供者的方法(服务)
        try {
            System.out.println(handlerServiceTwo.handleTwo("Hello"));
        } catch (Exception e){
            System.out.println("调用handlerServiceTwo异常" + e.getMessage());
        }
        System.out.println(handlerServiceOne.handleOne("Hello"));
    }
}
