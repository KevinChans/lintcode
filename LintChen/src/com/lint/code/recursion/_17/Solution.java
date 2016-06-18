package com.lint.code.recursion._17;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 6/17/16.
 * <p>
 * 子集
 * 给定一个含不同整数的集合，返回其所有的子集
 * 注意事项
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 * 样例
 * 如果 S = [1,2,3]，有如下的解：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        int[] nums = new int[]{
                1,2,3
        };
        ArrayList<ArrayList<Integer>> results = subsets(nums);
        for(ArrayList<Integer> integers:results){
            StringBuilder builder = new StringBuilder("[");
            for(Integer integer:integers){
                builder.append(integer).append(",");
            }
            if(builder.length() > 1){
                builder.deleteCharAt(builder.length()-1);
            }
            builder.append("]");
            System.out.println(builder.toString());
        }
    }
    /**
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        recursion(nums,0);
        return result;
    }
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public void recursion(int[] nums,int i){
        if(i == 0){
            ArrayList<Integer> nullSet = new ArrayList<>();
            ArrayList<Integer> newSet = new ArrayList<>();
            newSet.add(nums[i]);
            result.add(nullSet);
            result.add(newSet);
            recursion(nums, i+1);
        }else if(i < nums.length){
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            arrayLists.addAll(result);
            for(int j=0;j<arrayLists.size();j++){
                ArrayList<Integer> newSet = new ArrayList<>();
                newSet.addAll(arrayLists.get(j));
                newSet.add(nums[i]);
                result.add(newSet);
            }
            recursion(nums,i+1);
        }
    }
}
