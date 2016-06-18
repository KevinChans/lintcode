package com.lint.code.dp._29;

/**
 * Created by Kevin on 6/12/16.
 * <p>
 * 交叉字符串
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }

    /*
    比如 s1 = "aabcc" s2 = "dbbca"
    - 当 s3 = "aadbbcbcac"，返回  true.
    - 当 s3 = "aadbbbaccc"， 返回 false.
     */

    public Solution(){
        String s1 = "aabcc";
        String s2 = "dbbca";
        //String s3 = "aadbbcbcac";
        String s3 = "aadbbbaccc";
        s1="";
        s2="";
        s3="1";
        boolean result = isInterleave(s1,s2,s3);
        System.out.println("result="+result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        //考虑特殊情况
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        boolean[][] F = new boolean[s2.length()+1][s1.length()+1];
        F[0][0] = true;
        for(int i=0;i<=s2.length();i++){
            for(int j=0;j<=s1.length();j++){
                int k = i+j;
                if(j>0 && F[i][j-1]){
                    F[i][j] = s1.charAt(j-1) == s3.charAt(k-1);
                }
                if(i>0 && F[i-1][j]){
                    F[i][j] = s2.charAt(i-1) == s3.charAt(k-1);
                }
            }
        }
        return F[s2.length()][s1.length()];
    }
}
