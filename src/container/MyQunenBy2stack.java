package container;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Stack;

public class MyQunenBy2stack {

    //用栈实现队列
    //用两个栈来模拟实现队列
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQunenBy2stack() {
   stackA = new Stack<>();
   stackB = new Stack<>();
    }
   //A始终用来模拟入队列操作,B始终用来模拟出队列操作
    /** Push element x to the back of queue. */
    public void push(int x) {
   //先将B中元素倒腾进A中,再将新元素入A
        while (!stackB.empty()){
            int ret = stackB.pop();
            stackA.push(ret);
        }
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        //1.如果为空,直接返回null
        if (empty()){
            return null;
        }
    //2.将A中所有元素都入B
        while (!stackA.isEmpty()){
            int ret = stackA.pop();
            stackB.push(ret);
        }
        //3.此时栈顶元素就是队列中的队尾元素,将栈顶元素出栈即可
        int result =stackB.pop();
        return result;
    }

    /** Get the front element. */
    public Integer peek() {
        //1.如果为空,直接返回null
        if (empty()){
            return null;
        }
        //2.将A中所有元素都入B
        while (!stackA.isEmpty()){
            int ret = stackA.pop();
            stackB.push(ret);
        }
        //3.此时栈顶元素就是队列中的队尾元素,查找栈顶元素即可
        int result =stackB.peek();
        return result;
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
    return stackB.isEmpty() && stackA.isEmpty();
    }
}
