package com.lint.code.search.deep._90;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * k数和 II
 * 给定n个不同的正整数，整数k（1<= k <= n）以及一个目标数字。　　　　
 * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，你需要找出所有满足要求的方案。
 * 样例
 * 给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
 * 解决方法:同_16
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        new Solution();
    }

    public Solution(){
        int[] A = new int[]{
                //1,2,3,4
                1,4,7,10,12,15,16,18,21,23,24,25,26,29
        };
        //kSumII(A,2,5);
        kSumII(A,5,113);
        for(ArrayList<Integer> integers:result){
            StringBuilder builder = new StringBuilder();
            for(Integer integer:integers){
                builder.append(integer).append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            System.out.println("result="+builder.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(A,k,target,temp,k);
        return result;
    }
    //1,2,3,4
    public void dfs(int[] A,int k,int target,ArrayList<Integer> temp,int count){
        for(int i=0;i<A.length && k>0;i++){
            ArrayList<Integer> newTemp = new ArrayList<>();
            newTemp.addAll(temp);
            int a = A[i];
            newTemp.add(a);
            int[] B = delete(A,i);
            if(newTemp.size() == count && isEquals(newTemp,target)){
                result.add(newTemp);
            }else{
                dfs(B,k-1,target,newTemp,count);
            }
        }
    }

    /**
     * 删除i之前的数字
     * @param A
     * @param i
     * @return
     */
    public int[] delete(int[] A,int i){
        return Arrays.copyOfRange(A,i+1,A.length);
    }

    /**
     * 判断满足条件
     */
    public boolean isEquals(ArrayList<Integer> list,int target){
        int sum = 0;
        for(Integer integer:list){
            sum+=integer;
        }
        return sum == target;
    }

}
