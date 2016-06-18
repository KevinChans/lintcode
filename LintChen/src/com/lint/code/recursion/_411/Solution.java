package com.lint.code.recursion._411;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/17/16.
 * <p>
 * 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个二进制的差异。
 * 给定一个非负整数 n ，表示该代码中所有二进制的总数，请找出其格雷编码顺序。一个格雷编码顺序必须以 0 开始，并覆盖所有的 2n 个整数。
 * 注意事项
 * 对于给定的 n，其格雷编码顺序并不唯一。
 * 根据以上定义， [0,2,3,1] 也是一个有效的格雷编码顺序。
 * 样例
 * 给定 n = 2， 返回 [0,1,3,2]。其格雷编码顺序为：
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 000 - 0
 * 001 - 1
 * 011 - 3
 * 010 - 2 + 2i(i=2)
 * 110 - 6
 * 111 - 7
 * 101 - 5
 * O(2n) 时间复杂度。
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        ArrayList<Integer> results = grayCode(2);
        StringBuilder builder = new StringBuilder();
        for(Integer integer:results){
            builder.append(integer).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }

    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        recursion(n,0);
        return result;
    }
    private ArrayList<Integer> result = new ArrayList<>();
    public void recursion(int n,int i){
        if(i == 0){
            result.add(0);
            recursion(n,i+1);
        }else if(i <= n){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(result);
            for(int j=temp.size()-1;j>=0;j--){
                result.add(temp.get(j) + (int)Math.pow(2,i-1));
            }
            recursion(n,i+1);
        }
    }
}
