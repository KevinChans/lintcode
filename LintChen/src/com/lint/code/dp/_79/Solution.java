package com.lint.code.dp._79;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * 最长公共子串
 * 出两个字符串，找到最长公共子串，并返回其长度。
 * 样例
 * 给出A=“ABCD”，B=“CBCE”，返回 2
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        String A = "ABCD";
        String B = "CBCE";
        int result = longestCommonSubstring(A,B);
        System.out.println("result="+result);
    }

    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int[][] F = new int[A.length()+1][B.length()+1];
        int max = 0;
        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i==0 || j==0){
                    F[i][j] = 0;
                    continue;
                }
                if(A.charAt(i-1) == B.charAt(j-1)){
                    F[i][j] = F[i-1][j-1]+1;
                }else{
                    F[i][j] = 0;
                }
                max = Math.max(max,F[i][j]);
            }
        }
        return max;
    }
}
