package com.papa.baguwen1.baguwen1.algorithm;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

//236. 二叉树的最近公共祖先
public class Solution236 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<Integer> qq = new LinkedBlockingQueue<>();
//        Queue<Integer> pq = new LinkedBlockingQueue<>();
        findParent(root, p.val, qq, 1);
        findParent(root, q.val, qq, 2);
        return ans;
    }

    private boolean findParent(TreeNode node, int value, Queue<Integer> queue, int mode){
        if (node.val  == value){
            if (mode == 1) {
                queue.offer(node.val);
            } else {
                for (Integer integer : queue) {
                    if (integer == node.val){
                        ans = node;
                        return false;
                    }
                }
            }
            return true;
        }
        if (node.left == null && node.right == null){
            return false;
        }
        if (node.left != null){
            if (findParent(node.left, value, queue, mode)){
                if (mode == 1) {
                    queue.offer(node.val);
                } else {
                    for (Integer integer : queue) {
                        if (integer == node.val){
                            ans = node;
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        if (node.right != null){
            if (findParent(node.right, value, queue, mode)){
                if (mode == 1) {
                    queue.offer(node.val);
                } else {
                    for (Integer integer : queue) {
                        if (integer == node.val){
                            ans = node;
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, two, null);
        TreeNode treeNode = new Solution236().lowestCommonAncestor(root, two, root);
        System.out.println(treeNode.val);
    }
}
