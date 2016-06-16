package com.lint.code.search.deep._155;

import java.util.Stack;

/**
 * Created by Kevin on 6/14/16.
 * <p>
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 二叉树的最小深度为根节点到最近叶子节点的距离。
 * {1,#,2,3}
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private Solution(){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = left1;
        left1.left = left2;
        int result = minDepth(root);
        System.out.println("result="+result);
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right != null){
            return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
        }
        if(root.left != null){
            return minDepth(root.left)+1;
        }
        return minDepth(root.right)+1;
    }

    public int minDepth2(TreeNode root){
        int minDepth = 0;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while(true){
            TreeNode node = treeNodes.pop();

        }
    }


    //Definition of TreeNode:
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
