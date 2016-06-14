package com.lint.code.greedy._116;

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
                //0,2,3,1,1,4 //false
                //3,2,1,0,4 //false
                //2,3,1,1,4 //true
                //0         //true
        };
        boolean result = canJump1(A);
        System.out.println("result="+result);
    }

    public static boolean canJump(int[] A) {
        if(A == null || A.length == 0){
            return  true;
        }
        int len = A.length;
        if(A[0] <= 0 && len != 1){
            return false;
        }
        int[] F = new int[len];
        F[0] = A[0];
        for(int i = 1; i < len; i++){
            if((F[i] = Math.max(A[i],F[i-1] - 1)) <= 0 && i != len-1){
                return false;
            }
        }
        return true;
    }

    public static boolean canJump1(int[] A) {
        int i=0;
        for(int before = 0;i<A.length;i++){
            before = Math.max(A[i],before - 1);
            if(before <= 0 && i != A.length - 1){
                break;
            }
        }
        return i == A.length;
    }
}
