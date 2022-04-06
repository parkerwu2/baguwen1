package com.papa.baguwen1.baguwen1.algorithm;

import java.util.Arrays;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0){
            return 0;
        }
        int res = 1;
        int pre = nums[0];
        int cur = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == pre){
                continue;
            }
            if (nums[i] == pre + 1){
                cur++;
            } else {
                res = cur > res ? cur : res;
                cur = 1;
            }
            pre = nums[i];
        }
        res = cur > res ? cur : res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        System.out.println(new Solution128().longestConsecutive(nums));
    }
}
