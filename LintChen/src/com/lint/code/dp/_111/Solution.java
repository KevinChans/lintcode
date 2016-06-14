package com.lint.code.dp._111;

/**
 * Created by Kevin on 6/9/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        int result = climbStairs(3);
        System.out.println("result="+result);
    }

    public static int climbStairs(int n){
        if(n == 1){
            return 1;
        }
        int[] F = new int[n+1];
        F[0] = 1;
        for(int i=1;i <= n;i++){
            int l1 = F[i-1];
            int l2 = i >=2 ? F[i-2] : 0;
            F[i] = l1+l2;
        }
        return F[n];
    }
}
