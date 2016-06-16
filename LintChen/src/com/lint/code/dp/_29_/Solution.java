package com.lint.code.dp._29_;

/**
 * Created by Kevin on 6/12/16.
 * <p>
 * 交叉字符串
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        //String s3 = "aadbbbaccc";
        boolean result = isInterleave(s1,s2,s3);
        System.out.println("result="+result);
    }

    /*
    比如 s1 = "aabcc" s2 = "dbbca"
    - 当 s3 = "aadbbcbcac"，返回  true.
    - 当 s3 = "aadbbbaccc"， 返回 false.
     */

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        int j=0,k=0,i=0;
        while(i < len3){
            char temp = s3.charAt(i);
            boolean valid = false;
            if(j < len1 && temp == s1.charAt(j)){
                j++;
                valid = true;
            }else if(k < len2 && temp == s2.charAt(k)){
                k++;
                valid = true;
            }
            if(valid){
                i++;
            }else{
                break;
            }
        }
        return j == len1 && k == len2 && i == len3;
    }
    public static boolean isInterleave2(String s1, String s2, String s3) {

        return false;
    }
}
