package com.lint.code.recursion._427;

import java.util.ArrayList;

/**
 * Created by Kevin on 3/18/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    private static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args){
        generateParenthesis(2);
        arrayList.forEach(System.out::println);
    }

    public static ArrayList<String> generateParenthesis(int n) {
        generateParenthesis("(","",n-1,n);
        return arrayList;
    }

    public static void generateParenthesis(String current,String output,int left,int right){
        if(current.equals("(")){
            if(left != 0){
                generateParenthesis("(", output + current,left-1,right);
            }
            if(right != 0){
                generateParenthesis(")",output + current,left,right-1);
            }
        }else if(current.equals(")")){
            if(left == 0 && right == 0){
                System.out.println(output + current);
                arrayList.add(output + current);
                return;
            }
            if(right >= left){
                if(left != 0){
                    generateParenthesis("(", output + current,left-1,right);
                }
                if(right != 0){
                    generateParenthesis(")",output + current,left,right-1);
                }
            }
        }
    }
}
