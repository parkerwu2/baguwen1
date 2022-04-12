package com.papa.baguwen1.baguwen1.algorithm;

import java.util.HashMap;
import java.util.Map;

//meijiechulai
public class Solution166 {
    private Map<Integer, Integer> lastyu = new HashMap<>();
    public String fractionToDecimal(int numerator, int denominator) {
        int shang = numerator / denominator;
        int yu = numerator % denominator;
        if (yu == 0){
            return String.valueOf(shang);
        }
        String ans = shang + ".";
        int pos = ans.length() - 1;
        lastyu.put(yu, pos);
        yu *= 10;
        while (yu < denominator){
            yu *= 10;
            ans += "0";
        }
        return dealxiaoshu(yu, denominator, ans);
    }

    private String dealxiaoshu(int numerator, int denominator, String ans){
        int shang = numerator / denominator;
        int yu = numerator % denominator;
        if (yu == 0){
            return ans + shang;
        }
        ans += shang;
        if (lastyu.containsKey(yu)){
            int cpos = lastyu.get(yu);
            return ans.substring(0, cpos + 1) + "(" + ans.substring(cpos + 1) + ")";
        } else {
            int pos = ans.length() - 1;
            lastyu.put(yu, pos);
            yu *= 10;
            int zero = 0;
            while (yu < denominator){
                yu *= 10;
                zero++;
            }
            for (int i= 0; i < zero;  i++){
                ans += "0";
            }
            return dealxiaoshu(yu, denominator, ans);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution166().fractionToDecimal(1,2));
//        System.out.println(new Solution166().fractionToDecimal(2,1));
//        System.out.println(new Solution166().fractionToDecimal(4,333));
//        System.out.println(new Solution166().fractionToDecimal(1, 6));
        System.out.println(new Solution166().fractionToDecimal(1, 90));
    }
}
