package com.lint.code.string._8;

/**
 * Created by Kevin on 8/26/16.
 * <p>
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 样例
 * 对于字符串 "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * 挑战:在数组上原地旋转，使用O(1)的额外空间
 *
 * @author Kevin
 */
public class Solution {

    public Solution() {
        //char[] r = "".toCharArray();
        char[] r = "".toCharArray();
        rotateString(r, 10);
        for (char c : r) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    /**
     * @param str:    an array of char
     * @param offset: an
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        //对offset进行优化,减少遍历的次数
        if (str != null && str.length > 0) {
            offset = offset % str.length;
        }
        char x;
        while (str != null && str.length > 0 && offset > 0) {
            x = str[str.length - 1];
            for (int i = str.length - 1; i > 0; i--) {
                str[i] = str[i - 1];
            }
            offset--;
            str[0] = x;
        }
    }
}
