package com.lint.code.stack._12;

/**
 * Created by Kevin on 8/4/16.
 * <p>
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 * 注意事项
 * 如果堆栈中没有数字则不能进行min方法的调用
 * 如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        MinStack stack = new MinStack();
//        stack.push(2);
//        stack.push(1);
//        stack.push(3);
//        System.out.println(stack.min());
//        stack.pop();
//        stack.pop();
//        System.out.println(stack.min());
//        stack.push(3);
//        stack.push(0);
//        System.out.println(stack.min());

//        stack.push(1);
//        System.out.println(stack.pop());
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.min());
//        stack.push(1);
//        System.out.println(stack.min());

        stack.push(152);
        stack.pop();
        stack.push(163);
        stack.min();
        stack.push(177);
        stack.min();
        stack.pop();
        stack.min();
        stack.push(178);
        stack.min();
        stack.push(154);
        stack.pop();
        stack.pop();
        stack.min();
        stack.push(167);
        System.out.println(stack.min());
    }
}
