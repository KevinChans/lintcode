package com.lint.code.listnode._380;

import java.util.Stack;

/**
 * Created by Kevin on 6/21/16.
 * <p>
 * 两个链表的交叉
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 * 注意事项
 * 如果两个链表没有交叉，返回null。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 样例
 * 下列两个链表：
 * A:     a1 → a2
 *               ↘
 *                c1 → c2 → c3
 *                ↗
 * B:  b1 → b2 → b3
 * 在节点 c1 开始交叉。
 * 挑战
 * 需满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        ListNode headA = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head7 = new ListNode(7);
        ListNode head8 = new ListNode(8);
        ListNode head9 = new ListNode(9);
        headA.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head7;
        head7.next = head8;
        head8.next = head9;


        ListNode headB = new ListNode(0);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        headB.next = head5;
        head5.next = head6;
        head6.next = head3;

        ListNode result = getIntersectionNode(headA,headB);
        System.out.println("result="+result.val);
    }

    /**
     * 使用栈,从后往前遍历,找到第一个不相等的点,返回该点之后的点
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while(headA != null){
            stackA.push(headA);
            headA = headA.next;
        }
        while(headB != null){
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode temp;
        ListNode result = null;
        while(stackA.size() != 0 && stackB.size() != 0){
            if((temp = stackA.pop()) == stackB.pop()){
                result = temp;
                continue;
            }else{
                break;
            }
        }
        return result;
    }

    //Definition for ListNode.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
