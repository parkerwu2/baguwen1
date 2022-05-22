package com.papa.baguwen1.baguwen1.lambda;

public class TestFunction {
    private static String test(MyFunction<String> mf, String c){
        return  mf.getValue(c);
    }
    private static Integer test2(MyFunction<Integer> mf, Integer c){
        return  mf.getValue(c);
    }
    public static void main(String[] args) {
        System.out.println(test(s -> s.toUpperCase(), "abc"));
        MyFunction<Integer> mf2 = i -> i * i;
        System.out.println(test2(mf2, 2));
    }
}
