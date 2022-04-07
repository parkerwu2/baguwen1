package com.papa.baguwen1.baguwen1.algorithm;

import java.util.ArrayList;
import java.util.List;

//78. 子集
public class Solution78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }
    void dfs(int cur, int[] nums){
        if (cur == nums.length){
            List tmp = new ArrayList(list);
            ans.add(tmp);
            return;
        }
        list.add(nums[cur]);
        dfs(cur + 1, nums);
        list.remove(list.size() - 1);
        dfs(cur + 1, nums);
    }
}
