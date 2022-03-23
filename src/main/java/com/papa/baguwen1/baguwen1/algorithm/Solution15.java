package com.papa.baguwen1.baguwen1.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[0] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[left] + nums[right];
                if (sum == target){
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                } else if (sum > target){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> r = new Solution15().threeSum(new int[]{-2,0,0,2,2});
        r.forEach(l -> {
            for (int i = 0; i < l.size(); i++){
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        });
    }
}
