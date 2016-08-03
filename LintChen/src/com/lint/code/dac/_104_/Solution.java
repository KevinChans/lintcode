package com.lint.code.dac._104_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 6/18/16.
 * <p>
 * 合并k个排序链表
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 * 样例
 * 给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
 * @author Kevin
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public Solution() {
        List<ListNode> lists = new ArrayList<>();
//        lists.add(null);
//        lists.add(null);
//        lists.add(null);
//        lists.add(null);

//        for(int i=0;i<1000;i++){
//            lists.add(new ListNode(i));
//        }

//        ListNode node1 = new ListNode(5);
//        node1.next = new ListNode(6);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = null;
//        ListNode node5 = new ListNode(0);
//        ListNode node6 = new ListNode(8);
//        node5.next = node6;
//        ListNode node7 = new ListNode(9);
//        node6.next = node7;
//
//        lists.add(node1);
//        lists.add(node3);
//        lists.add(node4);
//        lists.add(node5);

        //[-10->-9->-9->-3->-1->-1->0->null,
        // -5->null,
        // 4->null,
        // -8->null,
        // null,
        // -9->-6->-5->-4->-2->2->3->null,
        // -3->-3->-2->-1->0->null]

        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-9);
        ListNode node3 = new ListNode(-9);
        ListNode node4 = new ListNode(-3);
        ListNode node5 = new ListNode(-1);
        ListNode node6 = new ListNode(-1);
        ListNode node7 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node8 = new ListNode(-5);

        ListNode node9 = new ListNode(4);

        ListNode node10 = new ListNode(-8);

        ListNode node11 = new ListNode(-9);
        ListNode node12 = new ListNode(-6);
        ListNode node13 = new ListNode(-5);
        ListNode node14 = new ListNode(-4);
        ListNode node15 = new ListNode(-2);
        ListNode node16 = new ListNode(2);
        ListNode node17 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;

        ListNode node18 = new ListNode(-3);
        ListNode node19 = new ListNode(-3);
        ListNode node20 = new ListNode(-2);
        ListNode node21 = new ListNode(-1);
        ListNode node22 = new ListNode(0);
        node18.next = node19;
        node19.next = node20;
        node20.next = node21;
        node21.next = node22;

        lists.add(node1);
        lists.add(node8);
        lists.add(node9);
        lists.add(node10);
        lists.add(node11);
        lists.add(node18);

        ListNode node = mergeKLists2(lists);
        StringBuilder builder = new StringBuilder();
        while(node != null){
            builder.append(node.val).append("->");
            node = node.next;
        }
        builder.append("null");
        System.out.println(builder.toString());
    }

    /**
     * 若是每次2个2个去进行合并，超时
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists2(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }
        ListNode cur = new ListNode(Integer.MAX_VALUE);
        ListNode root = cur;
        int tag=0;
        ListNode temp = new ListNode(0);
        ListNode t = null;
        //遍历list如果temp=null,说明每个链表都遍历完了
        while(temp != null){
            //遍历每个链表的第一个元素,找出最小的
            for(int i=0;i<lists.size();i++){
                temp = lists.get(i);
                //当前node不等于null,需要作比较判断是否插入
                if(temp != null){
                    if(temp.val < cur.val){
                        cur.val = temp.val;
                        tag = i;
                        t = temp;
                    }
                }
            }

            if(temp != null){
                lists.set(tag,t == null ? null : t.next);
                cur.next = new ListNode(Integer.MAX_VALUE);
                cur = cur.next;
            }
        }
        temp = root;
        ListNode pre = null;
        while(temp!=null && temp.val != Integer.MAX_VALUE){
            pre = temp;
            temp = temp.next;
        }
        if(pre != null){
            pre.next = null;
        }
        if(root != null && root.val == Integer.MAX_VALUE){
            return null;
        }
        return root;
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
