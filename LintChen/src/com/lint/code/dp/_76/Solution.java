package com.lint.code.dp._76;

/**
 * Created by Kevin on 6/16/16.
 * <p>
 * 最长上升子序列
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 * 说明,最长上升子序列的定义：
 * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
 * 样例:
 * 给出 [5,4,1,2,3]，LIS 是 [1,2,3]，返回 3
 * 给出 [4,2,4,5,3,7]，LIS 是 [4,4,5,7]，返回 4
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        int[] nums = new int[]{
                //5,4,1,2,3
                //4,2,4,5,3,7
                //1,2
                2,1
                //88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59
        };
        int result = longestIncreasingSubsequence(nums);
        System.out.println("result="+result);
    }

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 1;
        int[] F = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                F[i] = 1;
                continue;
            }
            int temp=nums[i];
            int max = 1;
            for(int j=i-1;j>=0;j--){
                if(temp >= nums[j]){
                    max = Math.max(max,F[j]+1);
                }
            }
            F[i] = max;
            result = Math.max(result,max);
        }
        return result;
    }
}
