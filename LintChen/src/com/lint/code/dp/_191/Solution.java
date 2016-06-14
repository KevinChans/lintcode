package com.lint.code.dp._191;

/**
 * Created by Kevin on 6/12/16.
 * <p>
 * 找出一个序列中乘积最大的连续子序列（至少包含一个数）。
 * 样例:
 * 比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
 *
 * [1,0,-1,2,3,-5,-2] 60
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        int[] nums = new int[]{
                //1,0,-1,2,3,-5,-2
                -4,-3
        };
        int result = maxProduct2(nums);
        System.out.println("result="+result);
    }

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public static int maxProduct2(int[] nums){
        int max = nums[0];
        int min = nums[0];
        //使用result记录最大值
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            int maxTemp = max !=0 ? max(cur,cur*max,cur*min) : cur;
            min = min !=0 ? min(cur, cur * max, cur * min) : cur;
            max = maxTemp;
            result = max(result,max);
            System.out.println("max="+max+",min="+min+",result="+result);
        }
        return result;
    }

    public static int max(int a,int b){
        return Math.max(a,b);
    }
    public static int max(int a,int b,int c){
        return Math.max(Math.max(a,b),c);
    }

    public static int min(int a,int b){
        return Math.min(a, b);
    }
    public static int min(int a,int b,int c){
        return Math.min(Math.min(a, b), c);
    }
}
