package com.pql.linked;

/**
 * 给定一个链表 每个节点中包含一个rand节点 随机指向链表中某个节点 也可能为null 要求复制出整个链表
 * @author pengqinglong
 * @since 2023/1/8
 */
public class CopyLinked {

    /**
     * 大致思路 把节点复制出来一套 然后将复制的节点放在原有节点的next上 然后将复制节点的next指向原有节点的next 然后再走random节点的指定
     */
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node node = new CopyLinked().copyLinked(node1);
        System.out.println(1);

    }
    private Node copyLinked(Node head){
        if(head == null){
            return null;
        }
        Node temp = head;

        while (temp != null){
            Node now = new Node(temp.value);
            Node next = temp.next;
            temp.next = now;
            now.next = next;
            temp = next;
        }

        Node cur = null;
        Node pre = head;
        while (pre != null){
            cur = pre.next;
            if(pre.random != null){
                cur.random = pre.random.next;
            }
            pre = pre.next.next;
        }

        Node result = head.next;
        cur = head.next;
        pre = head;
        while (cur != null){
            pre.next = cur.next;
            cur.next = cur.next == null ? null : cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        return result;
    }



    private static class Node{
        public int value;
        public Node next;
        public Node random;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node random){
            this.value = value;
            this.random = random;
        }
    }
}
