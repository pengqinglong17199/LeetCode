package com.pql.leetcode.offer.code18;

/**
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
