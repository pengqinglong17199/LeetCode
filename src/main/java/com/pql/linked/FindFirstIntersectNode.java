package com.pql.linked;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点 如果不相交 返回null
 *
 * 要求 时间复杂度O(N) 额外空间复杂度O(1)
 *
 * 1. 先用快慢指针找到两个链表的入环头
 * 2. 通过入环头判断几种情况
 * 3. 长链表-短链表的长度 然后再遍历链表
 * @author pengqinglong
 * @since 2023/1/10
 */
public class FindFirstIntersectNode {


    public static void main(String[] args)  {
// 1->2->3->4->5->6->7->null
        FindFirstIntersectNode find = new FindFirstIntersectNode();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(find.findFirstIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(find.findFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(find.findFirstIntersectNode(head1, head2).value);


    }

    private Node findFirstIntersectNode(Node node1, Node node2){

        if(node1 == null || node2 == null){
            return null;
        }

        Node loop1 = findLoop(node1);
        Node loop2 = findLoop(node2);

        if(loop1 == null && loop2 != null){
            return null;
        }

        if(loop1 != null && loop2 == null){
            return null;
        }

        if(loop1 == loop2){
            int length1 = 1;
            int length2 = 1;
            Node end1 = node1;
            Node end2 = node2;

            while (end1 != loop1){
                end1 = end1.next;
                length1++;
            }

            while (end2 != loop2){
                end2 = end2.next;
                length2++;
            }

            loop1 = length1 > length2 ? node1 : node2;
            loop2 = loop1 == node1 ? node2 : node1;
            int abs = Math.abs(length1 - length2);
            while (abs > 0){
                loop1 = loop1.next;
                abs--;
            }

            while (loop1 != end1){
                if(loop1 == loop2){
                    return loop1;
                }
                loop1 = loop1.next;
                loop2 = loop2.next;
            }

        }else {
            Node next = loop2.next;
            while (next != loop2){
                if(loop1 == next){
                    return loop1;
                }
                loop2 = loop2.next;
            }
        }
        return null;
    }

    private Node findEnd(Node node1) {
        Node end1 = node1;
        while (end1.next != null){
            end1 = node1.next;
        }
        return end1;
    }

    private Node findLoop(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while (slow != fast){

            if(fast == null){
                return null;
            }

            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }
        // 头尾相遇 重置快指针
        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
