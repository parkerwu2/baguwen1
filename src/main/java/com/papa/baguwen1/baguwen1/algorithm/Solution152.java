package com.papa.baguwen1.baguwen1.algorithm;

//152. 乘积最大子数组
public class Solution152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int[] minf = new int[len];
        int[] maxf = new int[len];
        minf[0] = nums[0];
        maxf[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            int cur = nums[i];
            minf[i] = Math.min(minf[i - 1] * cur, Math.min(maxf[i - 1] * cur, cur));
            maxf[i] = Math.max(minf[i - 1] * cur, Math.max(maxf[i - 1] * cur, cur));
        }
        for (int i : maxf) {
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        System.out.println(new Solution152().maxProduct(nums));
    }
}
