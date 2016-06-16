package com.lint.code.search.deep._33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kevin on 6/14/16.
 * <p>
 * 8皇后问题
 * @author Kevin
 */
public class Solution_8 {
    private static final int N = 8;

    public static void main(String[] args){
        new Solution_8();
    }

    public Solution_8(){
        List<int[]> result = new ArrayList<>();
        int[] temp = new int[N];
        dfs(result,temp,0);
        for(int[] list:result){
            StringBuilder builder = new StringBuilder();
            for(Integer ss:list){
                builder.append(ss).append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            System.out.println(builder.toString());
        }
    }

    /**
     * 解决8皇后问题
     * 思路:针对每一行分别判断每一列是否符合防止规则,如果满足则放置,并将row+1,进入下一行的判断,
     * 如果到了最后一行,如果满足规则,将该条放置顺序添加到列表
     * @return
     */
    public void dfs(List<int[]> re,int[] posi,int row) {
        for(int col=0;col<N;col++){
            if(isValid(row,col,posi)){
                posi[row]=col;
                if(row != N-1){
                    int[] ppp = Arrays.copyOf(posi,posi.length);
                    dfs(re,ppp,row+1);
                }else{
                    re.add(posi);
                }
            }
        }
    }

    public boolean isValid(int row,int col,int[] posi){
        for(int i=0;i<row;i++){
            if(posi[i] == col || (Math.abs(col - posi[i]) ==  row - i)){
                return false;
            }
        }
        return true;
    }

}
