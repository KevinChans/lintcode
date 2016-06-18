package com.lint.code.recursion._425;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kevin on 3/19/16.
 * <p>
 * 电话号码的字母组合
 * 给一个数字字符串，每个数字代表一个字母，请返回其所有可能的字母组合。
 * 下图的手机按键图，就表示了每个数字可以代表的字母。
 * 注意事项:以上的答案是按照词典编撰顺序进行输出的，不过，在做本题时，你也可以任意选择你喜欢的输出顺序。
 * 样例
 * 给定 "23"
 * 返回 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        ArrayList<String> result = letterCombinations("2");
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(String re:result){
            builder.append(re).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        System.out.println(builder.toString());
    }
    private ArrayList<String> result = new ArrayList<>();

    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        HashMap<Integer,String> dict = initDict();
        recursion(dict,digits,0);
        return result;
    }

    public HashMap<Integer,String> initDict(){
        HashMap<Integer,String> dict = new HashMap<>();
        dict.put(1,"");
        dict.put(2,"abc");
        dict.put(3,"def");
        dict.put(4,"ghi");
        dict.put(5,"jkl");
        dict.put(6,"mno");
        dict.put(7,"pqrs");
        dict.put(8,"tuv");
        dict.put(9,"wxyz");
        dict.put(0," ");
        return dict;
    }

    public void recursion(HashMap<Integer,String> dict,String digits,int index){
        if(index == digits.length()){
            return;
        }
        int key = Integer.valueOf(digits.substring(index, index + 1));
        String string = dict.get(key);
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(result);
        result.clear();
        for(int i=0;i<string.length();i++){
            char c = string.charAt(i);
            if(index == 0){
                result.add(""+c);
            }else{
                for(int j=0;j<temp.size();j++){
                    result.add(temp.get(j)+c);
                }
            }
        }
        recursion(dict,digits,index+1);
    }
}
