package com.pql.offer.code09;

import java.util.Stack;

/**
 * 剑指offer 09 用两个栈实现队列
 *      用两个栈实现一个队列。队列的声明如下，
 *      请实现它的两个函数 appendTail 和 deleteHead ，
 *      分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 *      (若队列中没有元素，deleteHead 操作返回 -1 )
 * @author pengqinglong
 * @since 2022/10/26 14:50
 */
public class CQueue {

    /**
     * 大致思路 栈是先进后出的  123的顺序入栈 出来的结果是321 所以用两个栈倒一次 321再入一次栈 就会变成123
     */
    private Stack<Integer> push;
    private Stack<Integer> pop;

    public CQueue() {
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

    public void appendTail(int value) {
        push.push(value);
    }

    public int deleteHead() {
        // 如果没值 返回-1
        if (pop.isEmpty() && push.isEmpty()) {
            return -1;
        }

        // 弹出数据前先尝试倒一轮数据
        handleStack();
        return pop.pop();
    }
}
