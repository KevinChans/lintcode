package com.lint.code.dp._513;

/**
 * Created by Kevin on 6/16/16.
 * <p>
 * 完美平方
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。
 * 样例
 * 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 * 给出 n = 13, 返回 2 因为 13 = 4 + 9。
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        new Solution();
    }
    public Solution(){
        int result = numSquares2(0);
        System.out.println("result="+result);
    }

    /**
     * 复杂度过高,超时
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        int[] F = new int[n+1];
        for(int i=1;i<=n;i++){
            int sqrt = (int) Math.sqrt(i);
            if(sqrt * sqrt == i){
                F[i] = 1;
                continue;
            }
            int min = i;
            for(int j=1;j<=i/2;j++){
                min = Math.min(min,F[j]+F[i-j]);
                if(min <= 2){
                    break;
                }
            }
            F[i] = min;
        }
        return F[n];
    }
    /**
     * 以下代码优化了一下,仅仅遍历1,2,...的平方,减少了复杂度
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares2(int n) {
        int[] F = new int[n+1];
        for(int i=1;i<=n;i++){
            int sqrt = (int) Math.sqrt(i);
            if(sqrt * sqrt == i){
                F[i] = 1;
                continue;
            }
            int min = i;
            for(int j=1;j<=i/2;j++){
                int temp = j*j;
                if(temp < i){
                    min = Math.min(min,F[temp]+F[i-temp]);
                }else{
                    break;
                }
            }
            F[i] = min;
        }
        return F[n];
    }
}
