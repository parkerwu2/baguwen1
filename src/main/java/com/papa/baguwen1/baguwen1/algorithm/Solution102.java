package com.papa.baguwen1.baguwen1.algorithm;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

//102. 二叉树的层序遍历
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (queue.size() > 0){
            Queue<TreeNode> temp = new LinkedBlockingQueue<>();
            List<Integer> one = new ArrayList<>();
            while (queue.size() > 0) {
                TreeNode treeNode = queue.poll();
                one.add(treeNode.val);
                if (treeNode.left != null) {
                    temp.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.offer(treeNode.right);
                }
            }
            queue = temp;
            result.add(one);
        }
        return result;
    }

    public static void main(String[] args) {
        //root = [3,9,20,null,null,15,7]
        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode root = new TreeNode(3, nine, twenty);
        List<List<Integer>> list = new Solution102().levelOrder(root);
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(l -> {
                l.forEach(
                        one -> {System.out.print(one + " ");}
                );
                System.out.println();
            });

        }
    }
}
