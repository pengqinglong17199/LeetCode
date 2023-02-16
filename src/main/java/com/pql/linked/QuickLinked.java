package com.pql.linked;

/**
 * 给定一个单向链表和一个变量k 将其划分成小于k的在左边 等于k的在中间 大于k的在右边
 * 1. 把链表放在数组中 快排思路解决
 * 2. 分成小中大三个子链表 再串起来
 * @author pengqinglong
 * @since 2023/1/8
 */
public class QuickLinked {

    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(8);
        node.next.next = new Node(7);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next.next = new Node(1);

        QuickLinked quickLinked = new QuickLinked();
        quickLinked.mergeNode(node, 5);
        System.out.println();
    }
    public Node mergeNode(Node head, int k){
        Node sh = null;
        Node st = null;
        Node mh = null;
        Node mt = null;
        Node bh = null;
        Node bt = null;

        while (head != null){
            if (head.value < k) {
                if(sh == null){
                    sh = head;
                    st = head;
                }else{
                    st.next = head;
                    st = head;
                }
            } else if (head.value == k) {
                if(mh == null){
                    mh = head;
                    mt = head;
                }else{
                    mt.next = head;
                    mt = head;
                }
            } else {
                if(bh == null){
                    bh = head;
                    bt = head;
                }else{
                    bt.next = head;
                    bt = head;
                }
            }
            head = head.next;
        }

        if(sh != null){
            st.next = mh;
            mh = mh == null ? sh : mh;
        }

        if(mh != null){
            mt.next = bh;
        }
        return mh;
    }
}
