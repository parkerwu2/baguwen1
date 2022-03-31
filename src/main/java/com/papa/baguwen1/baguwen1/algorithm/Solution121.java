package com.papa.baguwen1.baguwen1.algorithm;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int max = 0; //最高利润
        int min = Integer.MAX_VALUE; //最低买入价
        if (prices.length == 1){
            return 0;
        }
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
