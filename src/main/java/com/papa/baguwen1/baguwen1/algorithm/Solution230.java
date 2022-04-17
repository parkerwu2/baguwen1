package com.papa.baguwen1.baguwen1.algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution230 {
    class TreeNode {
        int val;
        com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode left;
        com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode left, com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void reverse(TreeNode node, List<Integer> l){
        if (node != null){
            l.add(node.val);
            reverse(node.left, l);
            reverse(node.right, l);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        reverse(root, l);
        Collections.sort(l);
        return l.get(k - 1);
    }

    public static void main(String[] args) {
        Solution230 solution230 = new Solution230();
        com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode two = solution230.new TreeNode(2, null, null);
        com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode one = solution230.new TreeNode(1, null, two);
        com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode four = solution230.new TreeNode(4, null, null);
        com.papa.baguwen1.baguwen1.algorithm.Solution230.TreeNode three = solution230.new TreeNode(3, one, four);

        System.out.println(solution230.kthSmallest(three, 2));
    }
}
