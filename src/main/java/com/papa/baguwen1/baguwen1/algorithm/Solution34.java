package com.papa.baguwen1.baguwen1.algorithm;

//34. 在排序数组中查找元素的第一个和最后一个位置
public class Solution34 {
    private int[] subSearch(int[] nums, int target, int left, int right){
        if (left > right){
            return new int[]{-1, -1};
        }
        int len = nums.length;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            int pre = mid - 1;
            int aft = mid + 1;
            while (pre >= 0) {
                if (nums[pre] == nums[mid]) {
                    pre--;
                } else {
                    break;
                }
            }
            while (aft <= len -1) {
                if (nums[aft] == nums[mid]) {
                    aft++;
                } else {
                    break;
                }
            }
            return new int[]{pre + 1, aft - 1};
        } else if (target > nums[mid]){
            return subSearch(nums, target,mid + 1, len - 1);
        } else {
            return subSearch(nums, target, left, mid - 1);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int len = nums.length;
        if (len == 0){
            return result;
        }
        return subSearch(nums, target, 0, len - 1);
    }

    public static void main(String[] args) {
//        int[] r = new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 8);
//        printA(r);
//        int[] r1 = new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 6);
//        printA(r1);
//        int[] r2 = new Solution34().searchRange(new int[]{}, 0);
//        printA(r2);
        int[] r = new Solution34().searchRange(new int[]{1,1,2}, 1);
        printA(r);
    }
    private static void printA(int[] r){
        for (int i = 0; i < r.length; i++){
            System.out.print(r[i] + " ");
        }
        System.out.println();
    }
}
