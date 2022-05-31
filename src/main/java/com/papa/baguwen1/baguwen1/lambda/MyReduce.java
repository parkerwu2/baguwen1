package com.papa.baguwen1.baguwen1.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyReduce {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        int result = numList.stream().reduce((a,b) -> a + b ).get();
        System.out.println(result);

        int result2 = numList.stream().reduce(1,(a,b) ->  a + b );
        System.out.println(result2);

        List<Integer> numList2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result3 = numList2.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("element-" + Integer.toString(b));
            return a;
        }, (a, b) -> null);
        System.out.println(result3);
//[element-1, element-2, element-3, element-4, element-5, element-6]

    }
}
