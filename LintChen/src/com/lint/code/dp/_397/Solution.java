package com.lint.code.dp._397;

/**
 * Created by Kevin on 3/17/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        int[] d = new int[]{
                99,55,7,29,80,33,19,23,6,35,40,27,44,74,5,17,52,36,67,32,37,42,18,77,66,62,97,79,60,94,30,2,85,22,26,91,3,16,8,0,48,93,39,31,63,13,71,58,69,50,21,70,61,43,12,88,47,45,72,76
        };
        System.out.println(longestIncreasingContinuousSubsequence(d));
    }

    public static int longestIncreasingContinuousSubsequence(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int[] B = new int[A.length];
        for(int i=0;i<A.length;i++){
            B[A.length - 1 - i] = A[i];
        }
        return Math.max(longestSequence(A),longestSequence(B));
    }

    private static int longestSequence(int[] A){
        int[] d = new int[A.length];
        for(int i = 0;i < A.length;i++){
            if(i == 0){
                d[i] = 1;
            }else{
                if(A[i] > A[i - 1]){
                    d[i] = d[i-1] + 1;
                }else{
                    d[i] = 1;
                }
            }
        }
        int current = 1;
        for(int i = 0;i < A.length;i++){
            current = Math.max(current,d[i]);
        }
        return current;
    }
}
