package com.pql.offer.code18;

/**
 * 剑指offer 第18题
 *  给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *  返回删除后的链表的头节点。
 * @author pengqinglong
 * @since 2022/10/19 19:37
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {

        while (head != null){
            if(head.val != val){
                break;
            }
            head = head.next;
        }

        ListNode pre = head;
        ListNode next = head.next;
        while (next != null){
            if (next.val == val) {
                pre.next = next.next;
            }else{
                pre = next;
            }
            next = next.next;
        }

        return head;
    }
}
