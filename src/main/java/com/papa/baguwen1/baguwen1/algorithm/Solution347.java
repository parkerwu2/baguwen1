package com.papa.baguwen1.baguwen1.algorithm;

import java.util.*;

//前 K 个高频元素
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            int n = nums[i];
            if (map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        int[] result = new int[k];
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2)-> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < k; i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int[] r = new Solution347().topKFrequent(nums, 2);
        for (int i : r) {
            System.out.print(i + " ");
        }
    }
}
