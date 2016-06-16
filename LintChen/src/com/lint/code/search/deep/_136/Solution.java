package com.lint.code.search.deep._136;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 6/14/16.
 * <p>
 * 分割回文串
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * 返回s所有可能的回文串分割方案。
 * 样例
 * 给出 s = "aab"，返回
 * [
 * ["aa", "b"],
 * ["a", "a", "b"]
 * ]
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        new Solution();
    }
    //方法:使用深度优先搜索,针对每一种可能进行搜索
    public Solution(){
        List<List<String>> result = partition("");
        for(List<String> list:result){
            StringBuilder builder = new StringBuilder();
            for(String ss:list){
                builder.append(ss).append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            System.out.println(builder.toString());
        }

        //boolean result = isPartition("aa");
        //System.out.println("result="+result);
    }
    /*
    * @param s: A string
    * @return: A list of lists of string
    */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(result,temp,s);
        return result;
    }

    /**
     * 递归调用体,
     * @param result
     * @param temp
     * @param source
     */
    public void dfs(List<List<String>> result,List<String> temp,String source){
        if(source.length() == 0){
            //len==0代表遍历到末尾
            result.add(temp);
            return;
        }
        //使用for循环分别截取0-len长度的字符串,判断是否为回文,如果是则加到temp
        for(int i=1;i<=source.length();i++){
            String t = source.substring(0,i);
            if(isPartition(t)){
                List<String> te = new ArrayList<>();
                te.addAll(temp);
                te.add(t);
                dfs(result,te,source.substring(i,source.length()));
            }
        }
    }

    /**
     * 判断字符串是否为回文
     * @param source
     * @return
     */
    public boolean isPartition(String source){
        int s = 0;
        int e = source.length() - 1;
        boolean valid = true;
        while(valid && e >= s){
            valid = source.charAt(s++) == source.charAt(e--);
        }
        return valid;
    }
}
