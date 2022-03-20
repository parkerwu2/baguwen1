package com.papa.baguwen1.baguwen1;

//双指针 力扣 11. 盛最多水的容器
public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j){
            int len = Math.min(height[i], height[j]);
            int width = j - i;
            int sum = len * width;
            if (sum > area){
                area = sum;
            }
            if (height[i] <= height[j]){
                i++;
            } else {
                j--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 1};
        System.out.println(new Solution().maxArea(height));
        height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}
