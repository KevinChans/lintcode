package com.lint.code.listnode._35;

/**
 * Created by Kevin on 6/21/16.
 * <p>
 * 翻转链表
 * 翻转一个链表
 * 样例
 * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 * 挑战:在原地一次翻转完成
 *
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
    }
    public Solution(){
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode result = reverse(head);
        System.out.println("result="+result);
    }
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            if(next != null){
                temp.next = next.next;
                next.next = head;
                head = next;
            }else{
                break;
            }
        }
        return head;
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
