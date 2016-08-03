package com.lint.code.listnode._36;

/**
 * Created by Kevin on 6/21/16.
 * <p>
 * 翻转链表 II
 * 翻转链表中第m个节点到第n个节点的部分
 * 注意事项
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 * 样例
 * 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
 * 挑战:在原地一次翻转完成
 *
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public Solution() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = reverseBetween(head,2,4);
        System.out.println("result="+head);
    }

    /**
     * @param head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = head;
        n = n-m;
        ListNode before = null;
        while (m >= 0) {
            //记录m点的前驱
            if(m == 2){
                before = temp;
                temp = temp.next;
            }else if (m == 1) {//开始对m点进行翻转
                ListNode cur = temp;
                while(cur != null && n > 0){
                    ListNode next = cur.next;
                    if(next != null){
                        cur.next = next.next;
                        next.next = temp;
                        temp = next;
                    }
                    n--;
                }
                if(before == null){
                    //如果before=null,说明m=1,翻转从第一个元素开始,那么直接返回temp,没有前驱
                    return temp;
                }else{
                    before.next = temp;
                }
            } else{
                temp = temp.next;
            }
            --m;
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
