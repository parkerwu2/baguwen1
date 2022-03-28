package com.papa.baguwen1.baguwen1.algorithm;

//38. 外观数列
public class Solution38 {
    public String countAndSay(int n) {
        String init = "1";
        if (n == 1){
            return init;
        }
        for (int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            char last = init.charAt(0);
            int num = 1;
            for (int j = 1; j < init.length(); j++){
                char cur = init.charAt(j);
                if (cur == last){
                    num++;
                } else {
                    sb.append(num).append(last);
                    last = cur;
                    num = 1;
                }
            }
            init = sb.append(num).append(last).toString();
        }
        return init;
    }

    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(5));
    }
}
