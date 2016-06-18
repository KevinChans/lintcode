package com.lint.code.recursion._93;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * 平衡二叉树
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,
 * 一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 * 样例
 * 给出二叉树 A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
 * A)  3            B)    3
 *    / \                  \
 *   9  20                 20
 *  /    \                / \
 * 15    7              15  7
 * 二叉树A是高度平衡的二叉树，但是B不是
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.right = node4;

        boolean result = isBalanced(node);
        System.out.println("result="+result);
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if(root != null){
            int temp = Math.abs(height(root.left)-height(root.right));
            if(temp > 1){
                return false;
            }else{
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }
        return true;
    }

    public int height(TreeNode root){
        if(root != null){
            return Math.max(height(root.left),height(root.right))+1;
        }
        return 0;
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
