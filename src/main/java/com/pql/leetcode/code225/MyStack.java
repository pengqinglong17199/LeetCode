package com.pql.leetcode.code225;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225 用栈实现队列
 *      请你仅使用两个队列实现一个后入先出（LIFO）的栈，
 *      并支持普通栈的全部四种操作（push、top、pop 和 empty）。

 *      实现 MyStack 类：
 *
 *      void push(int x) 将元素 x 压入栈顶。
 *      int pop() 移除并返回栈顶元素。
 *      int top() 返回栈顶元素。
 *      boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * @author pengqinglong
 * @since 2022/10/26 14:50
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    /**
     * 大致思路 队列先进先出 123进去123出来 所以需要两个队列 12直接传给第二个队列 剩下最后一个3再弹出 就可以实现123变321
     */
    private Queue<Integer> push;
    private Queue<Integer> pop;

    public MyStack() {
        push = new ArrayDeque<>();
        pop = new ArrayDeque<>();
    }

    public void push(int x) {
        push.offer(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }

        return handleQueue().poll();
    }

    private Queue<Integer> handleQueue() {
        while (push.size() > 1){
            pop.offer(push.poll());
        }

        Queue<Integer> temp = push;
        push = pop;
        pop = temp;

        return pop;
    }

    public int top() {
        if(empty()){
            return -1;
        }
        Queue<Integer> queue = handleQueue();
        Integer poll = queue.poll();
        push.offer(poll);
        return poll;
    }

    public boolean empty() {
        return push.isEmpty() && pop.isEmpty();
    }
}