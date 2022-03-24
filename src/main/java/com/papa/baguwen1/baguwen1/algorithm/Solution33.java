package com.papa.baguwen1.baguwen1.algorithm;

//力扣33 虽然是二分，但是我这个做法不行，应该是一边有序，一边无序
public class Solution33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return (nums[0] != target) ? -1 : 0;
        }
        boolean r = false;
        int midIdx = len / 2;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                midIdx = i;
                r = true;
                break;
            }
        }
        int left = 0, right = len - 1;
        if (r) {
            if (nums[midIdx] == target) {
                return midIdx;
            }
            if (nums[midIdx] > target){
                return -1;
            }
            if (nums[len - 1] < target) {
                left = 0;
                right = midIdx - 1;
            } else {
                left = midIdx + 1;
                right = len - 1;
            }
        }
        int partMid = (right + left) / 2;
        while (left <= right){
            if (left == right){
                if (nums[left] == target){
                    return left;
                } else {
                    break;
                }
            }
            if (nums[partMid] == target){
                return partMid;
            } else if (nums[partMid] > target){
                right = partMid - 1;
            } else {
                left = partMid + 1;
            }
            partMid  = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 s = new Solution33();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(s.search(new int[]{1}, 0));
        System.out.println(s.search(new int[]{1, 3}, 3));
        System.out.println(s.search(new int[]{5, 1, 3}, 3));
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 1));
    }
}
