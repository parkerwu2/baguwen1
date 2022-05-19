package com.papa.baguwen1.baguwen1.algorithm;

public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton(){
    }
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
