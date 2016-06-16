package com.lint.code.dp._77;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * 最长公共子序列
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 * 样例
 * 给出"ABCD" 和 "EDCA"，这个LCS是 "A" (或 D或C)，返回1
 * 给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        String A = "bedaacbade";
        String B = "dccaeedbeb";
        int result = longestCommonSubsequence(A,B);
        System.out.println("result="+result);
    }
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int[][] F = new int[A.length()+1][B.length()+1];
        for(int i = 0;i<=A.length();i++){
            F[i][0] = 0;
        }
        for(int i = 0;i<=B.length();i++){
            F[0][i] = 0;
        }
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    F[i][j] = F[i-1][j-1]+1;
                }else{
                    F[i][j] = Math.max(F[i][j-1],F[i-1][j]);
                }
            }
        }
        return F[A.length()][B.length()];
    }
}
