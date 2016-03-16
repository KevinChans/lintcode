package com.lint.code.integer._413;

/**
 * Created by Kevin on 3/15/16.
 * <p>
 *
 * @author Kevin
 */
public class Solution {
    public int reverseInteger(int n) {
        String result;
        String str = String.valueOf(n);
        if(str.contains("-")){
            result = str.substring(1,str.length());
            result = new StringBuilder(result).reverse().toString();
            result = "-" + result;
        }else{
            result = new StringBuilder(str).reverse().toString();
        }
        long value = Long.valueOf(result);
        if(value > Integer.MAX_VALUE){
            return 0;
        }
        return (int) value;
    }
}
