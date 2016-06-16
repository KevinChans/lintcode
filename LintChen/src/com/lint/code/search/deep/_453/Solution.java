package com.lint.code.search.deep._453;

/**
 * Created by Kevin on 6/14/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        new Solution();
    }

    private TreeNode result;
    private TreeNode temp;

    public Solution(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        flatten(root);

        StringBuilder builder = new StringBuilder();
        while(root != null){
            builder.append(root.val).append(",");
            root = root.right;
        }
        builder.deleteCharAt(builder.length()-1);
        System.out.println("result="+builder.toString());
    }

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        result = new TreeNode(0);
        temp = result;
        dfs(root);
        root.right = result.right != null ? result.right.right : null;
        root.left = null;//此处注意将left置为null
    }

    public void dfs(TreeNode root){
        if(root != null){
            temp.right = new TreeNode(root.val);
            temp = temp.right;
            dfs(root.left);
            dfs(root.right);
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
