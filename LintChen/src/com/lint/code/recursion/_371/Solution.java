package com.lint.code.recursion._371;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 6/18/16.
 * <p>
 * 用递归打印数字
 * 用递归的方法找到从1到最大的N位整数。
 * 注意事项:
 * 用下面这种方式去递归其实很容易：
 * recursion(i) {
 * if i > largest number:
 * return
 * results.add(i)
 * recursion(i + 1)
 * }
 * 但是这种方式会耗费很多的递归空间，导致堆栈溢出。你能够用其他的方式来递归使得递归的深度最多只有 N 层么？
 * 样例:
 * 给出 N = 1, 返回[1,2,3,4,5,6,7,8,9].
 * 给出 N = 2, 返回[1,2,3,4,5,6,7,8,9,10,11,...,99].
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        List<Integer> result = numbersByRecursion(2);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Integer re:result){
            builder.append(re).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        System.out.println(builder.toString());

    }
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        recursion(n,1);
        return result;
    }
    private List<Integer> result = new ArrayList<>();
    public void recursion(int n,int i){
        if(i > n){
            return;
        }
        List<Integer> temp = new ArrayList<>();
        temp.addAll(result);
        if(i == 1){
            for(int j=1;j<10;j++){
                result.add(j);
            }
        }else{
            int pw = (int) Math.pow(10,i-1);
            for(int k=1;k<10;k++){
                int t = pw*k;
                result.add(t);
                for(int j=0;j<temp.size();j++){
                    result.add(temp.get(j) + t);
                }
            }
        }
        recursion(n,i+1);
    }
}
