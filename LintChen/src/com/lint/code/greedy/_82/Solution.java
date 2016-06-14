package com.lint.code.greedy._82;

/**
 * Created by Kevin on 6/11/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        int[] A = new int[]{
                1,5,6,3,5,6,3
        };
        int result = singleNumber(A);
        System.out.println("result="+result);
    }

    public static int singleNumber(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int result=A[0];
        for(int i = 1;i < A.length; i++){
            result^=A[i];
        }
        return result;
    }
}
