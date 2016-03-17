package com.code.test.dp;

/**
 * Created by Kevin on 3/17/16.
 * <p>
 * 动态规划入门,最少硬币问题
 * 动态规划问题,其实就是找状态和状态转移方程的过程,
 * 找到了这两点,问题就算完成了一大半了.
 * @author Kevin
 */
public class MinCoins {
    public static void main(String[] args){
        System.out.println(getMinCoins(23));
    }

    /**
     * 返回n数值的钱所需要的最少硬币数量
     * @param n 需要凑够的钱总数
     * @return 返回最少的硬币数
     */
    private static int getMinCoins(int n){
        //coins 记录硬币的面值,这里共有三种面值的硬币,分别为1,3,5
        int[] coins = new int[]{1,3,5};
        //min数组是用来记录1,2,3...数值的钱需要的最少应硬币数量
        int min[] = new int[n+1];
        //根据状态转移方程,
        for(int i = 1;i < n + 1;i++){
            for(int j = 0;j < 3 && i >= coins[j];j++){
                //每次二级for循环结束后,min会被赋值为本轮循环的最小值,j=0时,min[i]=0,所以需要特殊处理
                if(j == 0){
                    min[i] = min[i - coins[j]] + 1;
                }else{
                    min[i] = Math.min(min[i - coins[j]] + 1,min[i]);
                }
            }
        }
        return min[n];
    }

}
