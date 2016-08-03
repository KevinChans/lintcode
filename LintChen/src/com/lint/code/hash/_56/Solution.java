package com.lint.code.hash._56;

import java.util.HashMap;

/**
 * Created by Kevin on 7/4/16.
 * <p>
 * 两数之和
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。
 * 注意事项
 * 你可以假设只有一组答案。
 * 样例
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        int[] numbers = new int[]{
                2,3
                //1,0,-1
        };
        int[] result = twoSum(numbers,5);
        StringBuilder builder = new StringBuilder();
        for(int tem : result){
            builder.append(tem).append(",");
        }
        if(builder.length() > 0){
            builder.deleteCharAt(builder.length()-1);
        }
        System.out.println("result:"+builder.toString());
    }

    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     * 遍历一遍,时间复杂度为O(n)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{
                Integer.MAX_VALUE,0
        };
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int value = target - numbers[i];
            if(hashMap.get(value) != null){
                int a = hashMap.get(value);
                if(a + i < result[0]+result[1]){
                    result[0] = a;
                    result[1] = i;
                }
            }
            Integer temp = hashMap.get(numbers[i]);
            if(temp == null){
                hashMap.put(numbers[i],i);
            }
        }
        result[0]++;
        result[1]++;
        return result;
    }
}
