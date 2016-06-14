package com.lint.code.dp._534;

import java.util.Map;

/**
 * Created by Kevin on 6/13/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        int[] A = new int[]{
                3,6,5,2,9
        };
        int result = houseRobber2(A);
        System.out.println("result="+result);
    }

    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public static int houseRobber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        boolean[] B = new boolean[len];
        B[0] = true;
        for(int i=0;i<len;i++){
            int before1 = i >= 1 ? nums[i-1] : 0;
            int before2 = i >= 2 ? nums[i-2] : 0;
            boolean beforeB2 = i >= 2 ? B[i-2] : i == 0;
            if(beforeB2 && i == len-1){
                nums[i] = Math.max(before1,Math.max(before2,nums[i]));
            }else{
                nums[i] = Math.max(before1,before2 + nums[i]);
                B[i] = nums[i] == before1 ? (i == 0 ? true : B[i-1]) : beforeB2;
            }
        }
        return nums[len-1];
    }

}
