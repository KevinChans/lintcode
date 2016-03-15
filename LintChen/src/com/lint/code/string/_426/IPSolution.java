package com.lint.code.string._426;

import java.util.ArrayList;

/**
 * Created by Kevin on 3/15/16.
 * <p/>
 * 详见 http://www.lintcode.com/zh-cn/problem/restore-ip-addresses
 * 根据输入的字符串恢复ip地址
 * @author Kevin
 */
public class IPSolution {
    private static ArrayList<String> arrayList = new ArrayList<String>();
    private static final char ZERO_VALUE = '0';
    private static final char DOT = '.';
    private static final int IP_LENGTH = 3;
    //总耗时: 9672 ms
    public void addDDDot(String input,String output,int k){
        if(k < 0 || input.equals("")){
            return;
        }
        if(k == 0){
            if(input.charAt(0) == ZERO_VALUE && input.length() != 1){
                return;
            }
            int value = Integer.valueOf(input);
            if(value >= 0 && value <= 255){//合法
                output += input;
                arrayList.add(output.toString());
            }
        }else{
            if(input.charAt(0) == ZERO_VALUE){
                output = output + ZERO_VALUE + DOT;
                addDDDot(input.substring(1,input.length()),new String(output),--k);
            }else{
                int m = --k;
                for(int i = 1;i <= IP_LENGTH && i <= input.length();i++){
                    int value= Integer.valueOf(input.substring(0, i));
                    if(value >= 0 && value <= 255){
                        addDDDot(input.substring(i,input.length()),new String(output + value + DOT),m);
                    }
                }
            }
        }
    }
    public void printResult(){
        System.out.println("The result is:");
        arrayList.forEach(System.out::println);
    }
}
