package com.lint.code.dp._116;

/**
 * Created by Kevin on 6/13/16.
 * <p>
 * 跳跃游戏
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
 * 判断你是否能到达数组的最后一个位置。
 * 样例
 * A = [2,3,1,1,4]，返回 true.
 * A = [3,2,1,0,4]，返回 false.
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        int[] A = new int[]{
                //2,3,1,1,4
                //3,2,1,0,4
                0
        };
        boolean result = canJump(A);
        System.out.println("result="+result);
    }

    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        if(A == null || A.length == 0){
            return true;
        }
        int len = A.length;
        boolean[] F = new boolean[len];
        F[0] = true;
        for(int i = 1; i < len; i++){
            for(int k = i-1;k >= 0; k--){
                if(F[i] = (A[k] >= (i-k) && F[k])){
                    break;
                }
            }
        }
        return F[len-1];
    }
}
