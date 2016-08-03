package com.lint.code.dac._428;

/**
 * Created by Kevin on 6/18/16.
 * <p>
 * x的n次幂
 * 实现 pow(x,n)
 * 注意事项
 * 不用担心精度，当答案和标准输出差绝对值小于1e-3时都算正确
 * 样例
 * Pow(2.1, 3) = 9.261
 * Pow(0, 1) = 0
 * Pow(1, 0) = 1
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        //double result = myPow(34.00515,-3);
        double result = myPow(34.00515,-3);
        System.out.println("result="+result);
    }
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n > 0){
            return x*myPow(x,n-1);
        }else{
            return (1d/x)*myPow(x,n+1);
        }
    }
}
