package com.lint.code.bt._67_;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * 二叉树的中序遍历
 * 给出一棵二叉树,返回其中序遍历
 * 样例
 * 给出二叉树 {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 返回 [1,3,2].
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){

    }

    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }

    private ArrayList<Integer> result = new ArrayList<>();

    public void recursion(TreeNode root){
        if(root != null){
            recursion(root.left);
            result.add(root.val);
            recursion(root.right);
        }
    }
    //TODO 非递归形式
    public void notRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                if(root.right != null){
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
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
