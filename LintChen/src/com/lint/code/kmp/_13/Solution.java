package com.lint.code.kmp._13;

import java.util.Arrays;

/**
 * Created by Kevin on 8/16/16.
 * <p>
 * 字符串查找
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * 说明
 * 在面试中我是否需要实现KMP算法？
 * 不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。当然你需要先跟面试官确认清楚要怎么实现这个题。
 * 样例
 * 如果 source = "source" 和 target = "target"，返回 -1。
 * 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 * 挑战
 * O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 * @author Kevin
 */
public class Solution {
    public Solution(){
        //int result = strStr("abcdabcdefg","bcd");
        //int result = strStr("source","target");
        //int result = strStr("source","");
        //int result = strStr("","");
        //int result = strStr("source","rced");
        //System.out.println("result:"+result);

        //int[] results = nexts("abcabbca");
        //for(int t : results){
        //    System.out.println(t );
        //}
        //int result = strStrKmp("aabcdabcdefg","bcd");
        int result = strStrKmp("a","");
        System.out.println("result:"+result);

    }
    public static void main(String[] args){
        Solution solution = new Solution();
    }

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //判空,防止NullPointException
        if(source == null || target == null){
            return -1;
        }
        for(int i = 0;i < source.length(); i++){
            int m = i;
            int j = 0;
            //注意m的范围需要比source.length()小
            for(;j < target.length() && m < source.length();j++,m++){
                char c = source.charAt(m);
                char t = target.charAt(j);
                if(c != t){
                    break;
                }
            }
            if(j == target.length()){
                return i;
            }
        }
        return source.equals(target) ? 0 : -1;
    }

    //使用KMP算法解决
    public int strStrKmp(String source, String target) {
        if(source == null || target == null){
            return -1;
        }
        if(target.equals("")){
            return 0;
        }
        int[] next = nexts(target);
        int i = next[0];
        int j = 0;
        while(i < source.length() && j < target.length()){
            char s = source.charAt(i);
            char t = target.charAt(j);
            if(s == t){
                i++;
                j++;
            }else{
                if(j > 0){
                    j = next[i-1];
                }else{
                    i++;
                }
            }
        }
        if(j == target.length()){
            return i - target.length();
        }
        return -1;
    }
    //找到next数组
    public int[] nexts(String target){
        int len = target.length();
        int[] next = new int[len];
        int i = 0,j = 0;
        next[0] = 0;
        while(i < len){
            if(j < i){
                char ci = target.charAt(i);
                char cj = target.charAt(j);
                if(ci == cj){
                    next[i] = j + 1;
                    i++;
                    j++;
                }else{
                    if(j > 0){
                        j = next[j-1];
                    }else{
                        i++;
                    }
                }
            }else{
                i++;
            }
        }
        return next;
    }
}
