package com.lint.code.listnode._96;

/**
 * Created by Kevin on 6/21/16.
 * <p>
 * 链表划分
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 * 你应该保留两部分内链表节点原有的相对顺序。
 * 样例
 * 给定链表 1->4->3->2->5->2->null，并且 x=3
 * 返回 1->2->2->4->3->5->null
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){

    }
    public Solution(){

    }
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode more = null;
        ListNode less = null;
        ListNode start = head;
        while(temp != null){
            if(temp.val >= x){
                if(more == null){
                    more = temp;
                }else{
                    more.next = temp;
                }
            }else {
                if(less == null){
                    less = temp;
                    start = temp;
                }else{
                    less.next = temp;
                }
            }
            temp = temp.next;
        }

        return start;
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
