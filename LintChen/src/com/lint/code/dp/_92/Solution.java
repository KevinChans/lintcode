package com.lint.code.dp._92;

/**
 * Created by Kevin on 3/20/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        int[] A = new int[]{
                2, 3, 5, 7
        };
        System.out.println(backPack(11, A));
    }

    public static int backPack(int m, int[] A) {
        int[] d = new int[m + 1];
        for(int i = 1;i <= m;i++){
            int temp = 0;
            for(int j = 0;j < A.length;j++){
                if(i == A[j]){
                    temp = i;
                }
            }
            for(int k = 1;k <= i/2;k++){
                if(temp <= (d[k] + d[i - k]) && k != (i - k)){
                    temp = d[k] + d[i - k];
                }
            }
            d[i] = temp;
        }
        return d[m];
    }
}
