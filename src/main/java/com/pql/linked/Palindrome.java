package com.pql.linked;

import java.util.Stack;

/**
 * 给定一个单链表的头节点head 请判断该链表是否为回文结构
 * 例如 123321 12321 这种
 * 1. 使用容器
 * 2. 不使用容器
 * @author pengqinglong
 * @since 2023/1/8
 */
public class Palindrome {
    private static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next  = new Node(2);
        node.next.next.next.next  = new Node(1);

        System.out.println( new Palindrome().isPalindrome1(node));
        System.out.println( new Palindrome().isPalindrome2(node));
        node.next.next.next.next  = new Node(0);
        System.out.println( new Palindrome().isPalindrome1(node));
        System.out.println( new Palindrome().isPalindrome2(node));
    }
    public boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        Node p1 = head;
        Node p2 = stack.pop();
        while (p1.value == p2.value){
            if(p1 == p2 || p1 == stack.peek()){
                return true;
            }
            p1 = p1.next;
            p2 = stack.pop();
        }
        return false;
    }

    public boolean isPalindrome2(Node head){
        //1>2>3<2<1
        //1>2 <2<1
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 保存慢指针中点和下一个点  后续慢指针将会复用
        Node mid = slow;

        // 中点的next作为第二条链表的头 来进行翻转
        Node n2 = slow.next;
        Node next = null;
        // 链表翻转
        while (n2 != null){
            next = n2.next;
            n2.next = slow;
            slow = n2;
            n2 = next;
        }
        n2 = slow;
        // 中点的next指向null 用于判断结束
        mid.next = null;

        // 第一条链表从头开始
        Node n1 = head;
        boolean flag = true;
        while (n1 != null){
            if(n1.value != n2.value){
                flag = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        Node lastNode = null;
        while (slow != null){
            next = slow.next;
            slow.next = lastNode;
            lastNode = slow;
            slow = next;
        }
        return flag;
    }
}
