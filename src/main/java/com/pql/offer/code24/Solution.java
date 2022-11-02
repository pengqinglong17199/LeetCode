package com.pql.offer.code24;

/**
 * 剑指offer第24题 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @author pengqinglong
 * @since 2022/10/19 19:06
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
