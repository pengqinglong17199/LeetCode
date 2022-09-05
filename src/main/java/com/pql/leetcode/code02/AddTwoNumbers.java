package com.pql.leetcode.code02;

/**
 * 02.两数相加
 * @author pengqinglong
 * @since 2022/9/2 16:47
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(node1, node2);

        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 前置判断
        if(l1 == null && l2 == null){
            return null;
        }

        // 前置判断
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node3 = null;
        ListNode result = null;

        int i = 0;
        while (node1 != null || node2 != null){

            int v1 = node1 != null ? node1.val : 0;
            int v2 = node2 != null ? node2.val : 0;

            int v3 = v1 + v2 + (i > 0 ? i-- : 0);

            if(v3 > 9){
                v3 = v3 %10;
                i++;
            }

            ListNode temp = new ListNode(v3);

            if(node3 != null){
                node3.next = temp;
            }
            if(result == null){
                result = temp;
            }
            node3 = temp;
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        return result;
    }
}
