package com.lint.code.hash._384;

import java.util.HashMap;

/**
 * Created by Kevin on 7/4/16.
 * <p>
 * 最长无重复字符的子串
 * 给定一个字符串，请找出其中无重复字符的最长子字符串。
 * 样例
 * 例如，在"abcabcbb"中，其无重复字符的最长子字符串是"abc"，其长度为 3。
 * 对于，"bbbbb"，其无重复字符的最长子字符串为"b"，长度为1。
 * (n) 时间
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        //int result = lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz");
        //int result = lengthOfLongestSubstring("abcabcbb");
        //int result = lengthOfLongestSubstring("");
        int result = lengthOfLongestSubstring("an++--viaj");
        System.out.println("result:"+result);
    }
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        int i=0;
        int result=0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        while(i<s.length()){
            Integer index = hashMap.get(s.charAt(i));
            if(index == null){
                count++;
                hashMap.put(s.charAt(i),i);
                i++;
            }else{
                result = Math.max(count,result);
                hashMap.clear();
                count = 0;
                i=index+1;
            }
        }
        return Math.max(result,count);
    }
}
