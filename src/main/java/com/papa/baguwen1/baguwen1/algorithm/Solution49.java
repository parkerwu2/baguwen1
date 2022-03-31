package com.papa.baguwen1.baguwen1.algorithm;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int len = strs.length;
        String one = strs[0];
        String sortOne = sortStr(one);
        List<String> l = new ArrayList<>();
        l.add(one);
        map.put(sortOne, l);
        for (int i = 1; i < len; i++){
            one = strs[i];
            sortOne = sortStr(one);
            if (map.containsKey(sortOne)){
                map.get(sortOne).add(one);
//                List<String> tmpL = map.get(sortOne);
//                tmpL.add(one);
//                map.put(sortOne, tmpL);

            } else {
                List<String> tmpL = new ArrayList<>();
                tmpL.add(one);
                map.put(sortOne, tmpL);
            }
        }
        res = new ArrayList<>(map.values());
        return res;
    }
    private String sortStr(String one){
        char[] charone = one.toCharArray();
        Arrays.sort(charone);
        StringBuilder sb = new StringBuilder();
        for (char c : charone) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new Solution49().groupAnagrams(strs);
        for (List<String> re : res) {
            re.forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }
}
