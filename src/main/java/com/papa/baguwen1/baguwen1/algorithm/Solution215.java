package com.papa.baguwen1.baguwen1.algorithm;

import java.util.Arrays;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - 5];
    }
}
