package com.lint.code.search.deep._16;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/14/16.
 * <p>
 * 带重复元素的排列
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 * 样例
 * 给出列表 [1,2,2]，不同的排列有：
 * [
 * [1,2,2],
 * [2,1,2],
 * [2,2,1]
 * ]
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        new Solution();
    }

    public Solution(){
        ArrayList<Integer> nums = new ArrayList<>();
        //nums.add(1);
        //nums.add(2);
        //nums.add(2);
        ArrayList<ArrayList<Integer>> dest = permuteUnique(nums);
        for(ArrayList<Integer> de:dest){
            StringBuilder builder = new StringBuilder();
            for(Integer integer:de){
                builder.append(integer).append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            System.out.println(builder.toString());
        }
    }

    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> dest = new ArrayList<>();
        ArrayList<Integer> eachResult = new ArrayList<>();
        dfs(dest,nums,eachResult,nums.size());
        return dest;
    }

    public void dfs(ArrayList<ArrayList<Integer>> dest, ArrayList<Integer> nums, ArrayList<Integer> eachResult,int size) {
        for(int i=0;i<nums.size();i++){
            Integer integer = nums.get(i);
            ArrayList<Integer> newResult = new ArrayList<>();
            newResult.addAll(eachResult);
            newResult.add(integer);
            if(newResult.size() == size){
                if(isUnique(dest,newResult)){
                    dest.add(newResult);
                }
            }else{
                ArrayList<Integer> newNums = new ArrayList<>();
                newNums.addAll(nums);
                newNums.remove(i);
                dfs(dest,newNums,newResult,size);
            }
        }
    }

    public boolean isUnique(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        for(ArrayList<Integer> re:result){
            int i;
            for(i=0;i<re.size();i++){
                if(!re.get(i).equals(temp.get(i))){
                    break;
                }
            }
            if(i == re.size()){
                return false;
            }
        }
        return true;
    }
}
