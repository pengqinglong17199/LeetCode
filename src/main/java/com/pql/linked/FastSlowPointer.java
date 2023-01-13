package com.pql.linked;

/**
 * 快慢指针
 *
 * 1. 输入链表的头节点 奇数返回中节点 偶数返回上中点
 * 2. 输入链表的头节点 奇数返回中节点 偶数返回下中点
 * 3. 输入链表的头节点 奇数返回中节点前一个 偶数返回上中点前一个
 * 4. 输入链表的头节点 奇数返回中节点前一个 偶数返回下中点前一个
 *
 * @author pengqinglong
 * @since 2023/1/8
 */
public class FastSlowPointer {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next  = new Node(4);

        Node node1a = new FastSlowPointer().pointer1(node);
        Node node2a = new FastSlowPointer().pointer2(node);
        Node node3a = new FastSlowPointer().pointer3(node);
        Node node4a = new FastSlowPointer().pointer4(node);


        node.next.next.next.next = new Node(5);
        Node node1b = new FastSlowPointer().pointer1(node);
        Node node2b = new FastSlowPointer().pointer2(node);
        Node node3b = new FastSlowPointer().pointer3(node);
        Node node4b = new FastSlowPointer().pointer4(node);

        System.out.println(123);


    }

    // 1. 输入链表的头节点 奇数返回中节点 偶数返回上中点
    public Node pointer1(Node head){
        // 快指针
        Node fast = head;
        // 慢指针
        Node slow = head;

        // 奇数情况 由于指针在头节点 所以节点默认-1 此时奇数链表变偶数 最后一步时next为空 慢节点会停留在中点位子
        // 偶数情况 由于指针在头节点 所以节点默认-1 此时偶数链表变奇数 最后一步时next不为空 此时慢节点停留在上中点 所以需要判断快节点走完后是否为空 用这个方式来控制慢指针停留在上中点
        while (fast != null && fast.next != null){

            fast = fast.next.next;
            // 如果快指针走完之后不为空 慢指针才走 这样可以保证快指针最后一次走时 慢指针在偶数情况下可以停留在上中点
            if(fast != null){
                slow = slow.next;
            }
        }

        // 快指针如果为空 则代表奇数 直接返回慢指针就是中点
        // 快指针如果不为空 则代表偶数 此时没有走一圈循环 所以慢节点还停留在上中点 所以直接返回慢指针
        return slow;
    }


    // 2. 输入链表的头节点 奇数返回中节点 偶数返回下中点
    public Node pointer2(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 3. 输入链表的头节点 奇数返回中节点前一个 偶数返回上中点前一个
    public Node pointer3(Node head){
        Node fast = head;
        Node slow = head;
        Node slowParent = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;

            if(fast != null) {
                slowParent = slow;
                slow = slow.next;
            }
        }
        return slowParent;
    }

    // 4. 输入链表的头节点 奇数返回中节点前一个 偶数返回下中点前一个
    public Node pointer4(Node head){

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){

            fast = fast.next.next;
            if(fast != null){
                slow = slow.next;
            }
        }

        return slow;
    }

    private static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
