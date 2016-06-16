package com.lint.code.search.deep._33;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/14/16.
 * <p>
 * n皇后问题
 * @author Kevin
 */
public class Solution_N {

    public static void main(String[] args){
        new Solution_N();
    }

    public Solution_N(){
        ArrayList<ArrayList<String>> result = solveNQueens(4);
        for(ArrayList<String> list:result){
            StringBuilder builder = new StringBuilder();
            for(String ss:list){
                builder.append(ss).append("\n");
            }
            System.out.println(builder.toString());
        }
    }

    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> posi = new ArrayList<>();
        for(int i=0;i<n;i++){
            posi.add(i,"");
        }
        dfs(result,posi,0,n);
        return result;
    }

    public void dfs(ArrayList<ArrayList<String>> re,ArrayList<String> posi,int row,int n) {
        for(int col=0;col<n;col++){
            if(isValid(row,col,posi)){
                posi.set(row,wrapQ(col,n));
                if(row != n-1){
                    ArrayList<String> newList = new ArrayList<>();
                    newList.addAll(posi);
                    dfs(re,newList,row+1,n);
                }else{
                    re.add(posi);
                }
            }
        }
    }
    public String wrapQ(int col,int N){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<N;i++){
            if(i == col){
                builder.append("Q");
                continue;
            }
            builder.append(".");
        }
        return builder.toString();
    }

    public boolean isValid(int row,int col,ArrayList<String> posi){
        for(int i=0;i<row;i++){
            if(posi.get(i).indexOf('Q')== col || (Math.abs(col - posi.get(i).indexOf('Q')) ==  row - i)){
                return false;
            }
        }
        return true;
    }

}
