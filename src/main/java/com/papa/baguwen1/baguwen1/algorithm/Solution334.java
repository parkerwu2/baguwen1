package com.papa.baguwen1.baguwen1.algorithm;

//334. 递增的三元子序列
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++){
            if (nums[i] > second){
                return true;
            } else if (nums[i] <= first){
                first = nums[i];
            } else {
                second = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-2,6};
        System.out.println(new Solution334().increasingTriplet(nums));
//        nums = new int[]{5,4,3,2,1};
//        System.out.println(new Solution334().increasingTriplet(nums));
    }
}
