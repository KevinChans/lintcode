package com.lint.code.bt._68_;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){

    }

    public Solution(){

    }

    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }

    private ArrayList<Integer> result = new ArrayList<>();
    public void recursion(TreeNode root){
        if(root != null){
            recursion(root.left);
            recursion(root.right);
            result.add(root.val);
        }
    }

    //TODO 非递归形式
    public void notRecursion(TreeNode root){

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
