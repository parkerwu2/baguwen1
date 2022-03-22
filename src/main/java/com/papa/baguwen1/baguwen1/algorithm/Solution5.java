package com.papa.baguwen1.baguwen1.algorithm;

//力扣5 最长回文子串 动态规划
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1){
            return s;
        }
        if (s.length() == 2){
            if (s.charAt(0) == s.charAt(1)){
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        if (len <= 2){
            return s;
        }
        int[][]dp = new int[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = 0;
                } else {
                    if (j - i < 3){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == 1 && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("ac"));
    }
}
