package com.lint.code.dp._115;

/**
 * Created by Kevin on 6/9/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        int result = uniquePaths(3,4);
        System.out.println("result="+result);
    }
    public static int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }
        if(m == 0 || n == 0){
            return 1;
        }
        int[][] F = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0){
                    F[i][j] = 1;
                    continue;
                }
                F[i][j] = F[i-1][j] + F[i][j-1];
            }
        }
        return F[m-1][n-1];
    }
}
