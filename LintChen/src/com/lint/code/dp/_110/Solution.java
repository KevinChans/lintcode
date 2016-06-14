package com.lint.code.dp._110;

/**
 * Created by Kevin on 6/9/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        int[][] grid = new int[][]{
                {1,2,7,1},
                {4,5,8,6},
                {3,2,1,5},
                {1,3,2,7}
        };
        int result = minPathSum(grid);
        System.out.println("result="+result);
    }

    public static int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int m = grid.length;//行
        int n = grid[0].length;//列
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    continue;
                }else{
                    if(j== 0){
                        grid[i][j] = grid[i][j] + grid[i-1][j];
                        continue;
                    }
                    if(i==0){
                        grid[i][j] = grid[i][j] + grid[i][j-1];
                        continue;
                    }
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
