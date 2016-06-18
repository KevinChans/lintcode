package com.lint.code.dp._512_;

/**
 * Created by Kevin on 6/16/16.
 * <p>
 * 解码方法
 * 一个消息包含A-Z通过以下规则编码
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 * 样例
 * 给你的消息为12，有两种方式解码 AB(12) 或者 L(12). 所以返回 2
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        //int result = numDecodings("2789011203");
        int result = numDecodings("11111878787676172120121101212918291829819");
        System.out.println("result="+result);
    }

    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if(s == null ||s.length() == 0){
            return 0;
        }
        int[] F = new int[s.length()+1];
        if(s.charAt(0) != '0'){
            F[0] = 1;
            F[1] = 1;
        }
        for(int i=1;i<s.length();i++){
            int temp = Integer.parseInt(s.substring(i-1,i+1));
            if(s.charAt(i) != '0'){
                if(temp >= 10 && temp <= 26){
                    F[i+1] = F[i-1]*2;
                    continue;
                }
            }else{
                if(temp > 26){
                    return 0;
                }
            }
            if(temp == 0){
                return 0;
            }
            F[i+1] = F[i];
        }
        return F[s.length()];
    }

}
