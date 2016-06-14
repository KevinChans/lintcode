package com.lint.code.dp._107;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kevin on 6/7/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Set<String> dict = new HashSet<>();
        dict.add("aaaaa");
        dict.add("aaa");
        String s = "aaaaaaaa";
        boolean result = wordBreak4(s, dict);
        System.out.println("result="+result);
    }
    public static boolean wordBreak(String s, Set<String> dict) {
        int k = 0;
        if(dict.contains(s)){
            return true;
        }
        while(k <= s.length()){
            String temp = s.substring(0,k);
            if(!temp.equals("") &&dict.contains(temp)){
                s = s.substring(k,s.length());
                k = 0;
            }else{
                k++;
            }
        }
        return s.equals("");
    }
    //内存占用过多
    public static boolean wordBreak2(String s, Set<String> dict) {
        int len = s.length();
        boolean[][] F = new boolean[len][len];
        if(dict.contains(s)){
            return true;
        }
        for(int k = 1; k <= len; k++){
            for(int i = 0; i <= len - k; i++){
                String substring = s.substring(i,i + k);
                boolean isWord = dict.contains(substring);
                int m = i + k - 1;
                if(isWord){
                    F[i][m] = isWord;
                }else{
                    for(int j = i; j <= i + k - 2; j++){
                        F[i][m] = F[i][j] && F[j+1][m];
                        if(F[i][m]){
                            break;
                        }
                    }
                }
            }
        }
        return dict.size() == 0 ? s.equals("") : F[0][len-1];
    }
    //超时
    public static boolean wordBreak3(String s, Set<String> dict){
        //考虑特殊情况
        if(s == null || (dict.size() == 0 && !s.equals("") )){
            return false;
        }
        int len = s.length();
        boolean[] F = new boolean[len+1];
        F[0] = true;
        //超时应该考虑下复杂度,减少循环次数
        for(int i = 1;i <= len; i++){
            for(int k = i-1; k >= 0; k--){
                F[i] = dict.contains(s.substring(k,i)) && F[k] == true;
                if(F[i]){
                    break;
                }
            }
        }
        return F[len];
    }
    //优化了代码,如下,减少了循环的次数
    public static boolean wordBreak4(String s, Set<String> dict){
        if(s == null || (dict.size() == 0 && !s.equals("") )){
            return false;
        }
        int len = s.length();
        boolean[] F = new boolean[len+1];
        F[0] = true;
        for(int i = 1;i <= len; i++){
            //通过来遍历dict来减少循环次数
            for(String word : dict){
                int length = word.length();
                if(i >= length){
                    F[i] = word.equals(s.substring(i-length,i)) && F[i-length];
                    if(F[i]){
                        break;
                    }
                }
            }
        }
        return F[len];
    }
}
