package com.pql.linked;

import com.pql.sort.Heap;

/**
 * 给定个链表如果长度是偶数 则将其分为左右两边 同时穿插合并
 *
 * 例 l1 l2 l3 l4 r1 r2 r3 r4
 * 合并后 l1 r4 l2 r3 l3 r2 l4 r1
 * @author pengqinglong
 * @since 2023/1/8
 */
public class Merge {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        //node.next.next.next.next.next.next.next.next = new Node(9);

        Node node1 = new Merge().mergeLinked(node);
        System.out.println();

    }

    /**
     * 大致思路 先通过快慢指针找到链表中点 偶数拿到上中点 然后把链表变成这样 1>2>3<4<5 抓到头和尾 然后 1>5>2>4>3 注意好结束的时候的边界条件
     */
    public Node mergeLinked(Node head){
        Node result = head;

        Node z = getZ(head);

        Node tail = z.next;
        Node pre = z ;
        Node next = null;
        while (tail.next != null){
            next = tail.next;
            tail.next = pre;
            pre = tail;
            tail = next;
        }
        tail.next = pre;
        z.next = null;

        Node hn = head;
        Node tn = tail;
        while (tn.next != z){
            hn = head.next;
            head.next = tn;
            head = hn;

            tn = tail.next;
            tail.next = hn;
            tail = tn;
        }
        if (hn.next == null) {
            z.next = tn;
            tn.next = null;
        }else{
            hn.next = tn;
        }

        return result;
    }

    private Node getZ(Node head) {
        Node kuai = head;
        Node man = head;
        while (kuai.next != null && kuai.next.next != null){
            kuai = kuai.next.next;
            man = man.next;
        }
        return man;
    }

    private static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
