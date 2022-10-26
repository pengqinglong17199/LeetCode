package com.pql.leetcode.offer2.code24;

/**
 * @author pengqinglong
 * @since 2022/10/19 19:47
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
