package com.pql.leetcode.code232;

import java.util.Stack;

/**
 *
 *  232 用栈实现队列
 *  请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 *      实现 MyQueue 类：
 *
 *      void push(int x) 将元素 x 推到队列的末尾
 *      int pop() 从队列的开头移除并返回元素
 *      int peek() 返回队列开头的元素
 *      boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * @author pengqinglong
 * @since 2022/10/26 15:44
 */
public class MyQueue {

    /**
     * 大致思路 栈是先进后出的  123的顺序入栈 出来的结果是321 所以用两个栈倒一次 321再入一次栈 就会变成123
     */
    private Stack<Integer> push;
    private Stack<Integer> pop;

    public MyQueue(){
        push = new Stack<>();
        pop = new Stack<>();
    }

    /**
     * 两个栈倒数据
     */
    private void handleStack(){
        // pop不为空时不能倒 否则数据顺序会乱
        if(pop.isEmpty()){
            // 倒数据必须 一次性全部倒完 否则顺序就乱了
            while (!push.isEmpty()){
                pop.push(push.pop());
            }
        }
    }

    public void push(int x){
        push.push(x);
    }

    public int pop(){
        // 弹出数据前先尝试倒一轮数据
        handleStack();

        // 如果没值 返回-1
        if (pop.isEmpty()) {
            return -1;
        }

        return pop.pop();
    }

    public int peek(){
        // 弹出数据前先尝试倒一轮数据
        handleStack();

        // 如果没值 返回-1
        if (pop.isEmpty()) {
            return -1;
        }

        return pop.peek();
    }

    public boolean empty(){
        return pop.isEmpty() && push.isEmpty();
    }

}
