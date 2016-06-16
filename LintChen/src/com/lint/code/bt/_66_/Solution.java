package com.lint.code.bt._66_;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * 二叉树的前序遍历
 * 给出一棵二叉树，返回其节点值的前序遍历。
 * 样例
 * 给出一棵二叉树 {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * 返回 [1,2,3].
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node8;
        node2.left = node3;
        node2.right = node6;
        node3.left = node4;
        node3.right = node5;
        node6.left = node7;

        notRecursion(node1);

        for(Integer integer:result){
            System.out.print(integer+"  ");
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }

    private ArrayList<Integer> result = new ArrayList<>();

    //递归形式
    public void recursion(TreeNode root){
        if(root != null){
            result.add(root.val);
            recursion(root.left);
            recursion(root.right);
        }
    }

    //TODO 非递归形式
    private void notRecursion(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        if(node != null){
            stack.push(node);
            while(!stack.isEmpty()){
                node = stack.pop();
                result.add(node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }

    public void notRecursion2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || stack.size() != 0){
            while (temp != null){
                result.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
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
