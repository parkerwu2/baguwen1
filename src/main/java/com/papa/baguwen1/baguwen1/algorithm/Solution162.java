package com.papa.baguwen1.baguwen1.algorithm;



public class Solution162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return 0;
        }
        for (int i = 0; i < len; i++){
            if (i == 0){
                if (nums[i + 1] < nums[i]) {
                    return i;
                }
                continue;
            }
            if (i == len - 1){
                 if (nums[len - 2] < nums[i]){
                     return i;
                 }
                 continue;
            }
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        System.out.println(new Solution162().findPeakElement(a));
    }
}
