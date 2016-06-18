package com.lint.code.greedy._41;

/**
 * Created by Kevin on 6/17/16.
 * <p>
 * 最大子数组
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * 注意事项
 * 子数组最少包含一个数
 * 样例
 * 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        int[] nums=new int[]{
        -2,2,-3,4,-1,2,1,-5,3
        };
        int result = maxSubArray(nums);
        System.out.println("result="+result);
    }

    /**
     * 遍历一遍数组,如果当前数字为正数,cur记录下,sum+=cur,取cur和sum的最大值,如果小于0,则sum+=当前值,并用max记录最大值
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = nums[0];
        int cur;
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = nums[i];
            if(temp > 0){
                cur = temp;
                sum=Math.max(sum+temp,cur);
            }else{
                sum+=temp;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
