package com.lint.code.greedy._46;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/16/16.
 * <p>
 * 主元素
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 样例
 * 给出数组[1,1,1,1,2,2,2]，返回 1
 * 挑战:要求时间复杂度为O(n)，空间复杂度为O(1)
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        //1,1,1,1,2,2,2
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(2);
        int result = majorityNumber(integers);
        System.out.println("result="+result);
    }
    /**
     * 使用cur来代表最终求解的元素,遍历该数组,如果相同,count+1,否则,count-1,
     * 如果count小于0,则替换为当前元素,最后可得主元素cur.
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 1;
        int cur = nums.get(0);
        for(int i=1;i<nums.size();i++){
            int x = nums.get(i);
            if(count > 0){
                if(cur == x){
                    count++;
                }else{
                    count--;
                }
            }else{
                cur = x;
            }
        }
        return cur;
    }
}
