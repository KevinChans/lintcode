package com.lint.code.string._422;

import java.util.Stack;

/**
 * Created by Kevin on 8/26/16.
 * <p>
 * 给定一个字符串， 包含大小写字母、空格' '，请返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 *  注意事项
 * 一个单词的界定是，由字母组成，但不包含任何的空格。
 * 样例
 * 给定 s = "Hello World"，返回 5。
 * @author Kevin
 */
public class Solution {
    public Solution(){
        int result = lengthOfLastWord("Hello World");
        System.out.println("result:"+result);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        int result = 0;
        //注意判空
        if(s != null && !s.equals("")){
            Stack<Character> stack = new Stack<>();
            s = s.trim();
            for(char c : s.toCharArray()){
                stack.push(c);
            }
            //注意边界
            while(stack.size() != 0 && stack.pop() != ' '){
                result++;
            }
        }
        return result;
    }
}
