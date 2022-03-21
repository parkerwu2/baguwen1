package com.papa.baguwen1.baguwen1.algorithm;

import java.util.HashSet;
import java.util.Set;

//力扣3 无重复字符的最长子串， 滑动窗口
//当出现重复字符串以后，左端移动到重复字符串后一个位置
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int left = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int j = 1; j < s.length(); j++){
            char cur = s.charAt(j);
            if (set.contains(cur)) {
                int len = set.size();
                if (len > maxLen) {
                    maxLen = len;
                }
                while (s.charAt(left) != cur){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                set.add(cur);
            } else {
                set.add(cur);
            }
        }
        if (set.size() > maxLen){
            maxLen = set.size();
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
        s = "au";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}
