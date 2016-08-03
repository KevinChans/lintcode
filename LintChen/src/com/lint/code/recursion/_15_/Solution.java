package com.lint.code.recursion._15_;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/21/16.
 * <p>
 * 全排列
 * 给定一个数字列表，返回其所有可能的排列。
 * 样例
 * 给出一个列表[1,2,3]，其全排列为：
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        ArrayList<ArrayList<Integer>> result = permute(nums);
        System.out.println("result="+result);
    }

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return result;
        }
        recursion(nums,new ArrayList<Integer>());
        return result;
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public void recursion(ArrayList<Integer> nums,ArrayList<Integer> each){
        if(nums.size() == 0){
            result.add(each);
            return;
        }

        for(int i=0;i<nums.size();i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(nums);

            ArrayList<Integer> eachTemp = new ArrayList<>();
            eachTemp.addAll(each);
            Integer integer = nums.get(i);
            eachTemp.add(integer);
            temp.remove(i);
            recursion(temp,eachTemp);
        }
    }

    //TODO 考虑使用非递归
    public ArrayList<ArrayList<Integer>> permute2(ArrayList<Integer> nums) {

        return null;
    }
}
