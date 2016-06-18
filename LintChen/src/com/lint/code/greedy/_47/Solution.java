package com.lint.code.greedy._47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Kevin on 6/16/16.
 * <p>
 * 主元素 II
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 * 注意事项:数组中只有唯一的主元素
 * 样例
 * 给出数组[1,2,1,2,1,3,3] 返回 1
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        //1,2,1,2,1,3,3
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(153, 124, 1, 150, 20, 92, 92, 92, 128, 69, 3, 42, 106, 101, 159, 112, 48, 92, 99, 77, 182, 22, 186, 34, 62, 170, 142, 90, 65, 91, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92));
        int result = majorityNumber2(integers);
        System.out.println("result="+result);
    }

    /**
     * 使用HashMap来简化问题
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Integer integer;
        for(int i=0;i<nums.size();i++){
            integer = nums.get(i);
            if(hashMap.get(integer) == null){
                hashMap.put(integer,1);
            }else{
                hashMap.put(integer,hashMap.get(integer)+1);
            }
            if(hashMap.get(integer) > nums.size()/3){
                return integer;
            }
        }
        return 0;
    }

    /**
     * 使用抵消法
     * @param nums
     * @return
     */
    public int majorityNumber2(ArrayList<Integer> nums) {
        int count1 = 0;
        int count2 = 0;
        int cur1 = Integer.MIN_VALUE;
        int cur2 = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            int x = nums.get(i);
            if(x == cur1){
                count1++;
            }else if(x == cur2){
                count2++;
            }else if(count1 == 0){
                count1++;
                cur1 = x;
            }else if(count2 == 0){
                count2++;
                cur2 = x;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i) == cur1){
                count1++;
            }else if(nums.get(i) == cur2){
                count2++;
            }
        }
        return count1 > count2 ? cur1 : cur2;
    }

}
