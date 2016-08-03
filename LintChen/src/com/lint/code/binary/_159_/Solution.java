package com.lint.code.binary._159_;

/**
 * Created by Kevin on 6/28/16.
 * <p>
 * 寻找旋转排序数组中的最小值
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复的元素。
 * 样例
 * 给出[4,5,6,7,0,1,2]  返回 0
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){

    }
    public Solution(){
        int[] num=new int[]{
                4,5,6,7,0,1,2
        };

    }
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        return Math.min(num[0],getPoint(num));
    }
    //二分法查找point
    public int getPoint(int[] nums){
        int i=0,j=nums.length;
        int m;
        while(i <= j){
            m=(i+j)/2;
            if(m==0){
                return 0;
            }
            if(m+1==nums.length-1){
                if(nums[m-1] > nums[m]){
                    return m;
                }
            }
            if(nums[m] < nums[i-1] && nums[m] > nums[i+1]){
                return m;
            }
            if(nums[i] <= nums[m]){
                i=m+1;
            }else if(nums[i] > nums[m]){
                j=m-1;
            }
        }
        return 0;
    }












}
