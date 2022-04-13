package com.papa.baguwen1.baguwen1.algorithm;
//189. 轮转数组
public class Solution189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] cp = new int[len];
        for (int i = 0; i < len; i++){
            cp[(i + k) % len] = nums[i];
        }
        System.arraycopy(cp, 0, nums, 0, len);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        nums = new int[]{1,2,3,4,5,6,7};
        new Solution189().rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
