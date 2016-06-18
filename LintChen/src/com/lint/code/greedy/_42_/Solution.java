package com.lint.code.greedy._42_;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 6/17/16.
 * <p>
 * 最大子数组 II
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 * 注意事项:子数组最少包含一个数
 * 样例
 * 给出数组 [1, 3, -1, 2, -1, 2]
 * 给出数组 [1, 3, -1, 2, -3, 2]
 * 这两个子数组分别为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2]，它们的最大和都是 7
 * 要求时间复杂度为 O(n)
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }

    public Solution(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(1, 3, -1, 2, -1, 2));
        int result = maxTwoSubArrays(integers);
        System.out.println("result="+result);
    }

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() < 2){
            return 0;
        }
        int sum=nums.get(0);
        int cur;
        int max1=nums.get(0);
        for(int i=1,j=nums.size()-1;i<nums.size()&&j>=0;i++,j--){
            int temi=nums.get(i);
            if(temi > 0){
                cur=temi;
                sum = Math.max(cur,sum+cur);
            }else{
                sum+=temi;
            }
            max1 = Math.max(max1,sum);
        }
        return max1;
    }
}
