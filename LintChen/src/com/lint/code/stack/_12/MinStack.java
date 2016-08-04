package com.lint.code.stack._12;

import java.util.Stack;

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
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int number) {
        stack.push(number);
        if(number <= min){
            min = number;
        }
        minStack.push(min);
    }

    public int pop() {
        minStack.pop();
        if(minStack.size() == 0){
            min = Integer.MAX_VALUE;
        }else{
            min = minStack.lastElement();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.lastElement();
    }
}
