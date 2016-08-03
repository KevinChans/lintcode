package com.lint.code.binary._14;

/**
 * Created by Kevin on 6/28/16.
 * <p>
 * 二分查找
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
 * 样例
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
 * 挑战: 如果数组中的整数个数超过了2^32，你的算法是否会出错？
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        int[] nums = new int[]{
                //3,4,5,8,8,8,8,10,13,14
                3,4,5,8,8,8,8,10,13,14
        };
        int result = binarySearch(nums,9);
        System.out.println("result="+result);
    }

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i=0,j=nums.length-1;
        int m;
        int result=-1;
        while(i <= j){
            m=(i+j)/2;
            if(nums[m] == target){
                result = m;
            }
            if(nums[m] >= target){
                j=m-1;
            }else if(nums[m] < target){
                i=m+1;
            }
        }
        return result;
    }
}
