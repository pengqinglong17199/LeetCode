package com.pql.offer.code23;

public class Solution {
    public ListNode getIntersectionNode(ListNode node1, ListNode node2) {
        if(node1 == null || node2 == null){
            return null;
        }

        if(node1 == node2){
            return node1;
        }

        int n = 0;
        ListNode end1 = node1;
        ListNode end2 = node2;

        while (end1.next != null){
            end1 = end1.next;
            n++;
        }

        while (end2.next != null){
            end2 = end2.next;
            n--;
        }

        ListNode cur1 = n > 0 ? node1 : node2;
        ListNode cur2 = cur1 == node1 ? node2 : node1;
        int abs = Math.abs(n);
        while (abs > 0){
            cur1 = cur1.next;
            abs--;
        }

        while (cur1 != end1){
            if(cur1 == cur2){
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(cur1 == cur2){
            return cur1;
        }
        return null;
    }
}