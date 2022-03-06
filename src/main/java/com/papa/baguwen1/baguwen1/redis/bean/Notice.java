package com.papa.baguwen1.baguwen1.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Notice implements Serializable {
    private String name;
    private String val;
    //分析原因:redis的这些序列化方式,使用的是无参构造函数进行创建对象set方法进行赋值,
    //方法中存在有参的构造函数,默认存在的无参构造函数是不存在的(继承自object),必须显示的去重写.
    public Notice(){}
}
