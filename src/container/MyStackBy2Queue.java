package container;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {

    //用队列实现栈 力扣225
    //可以用两个队列来模拟实现栈的情况 仅考察,无实际用途
    //用队列实现先进后出操作
    Queue<Integer> A;
    Queue<Integer> B;
    /** Initialize your data structure here. */
    public MyStackBy2Queue() {
        //这里不能用ArrayList();因为ArrayList没有实现Queue的接口;
        A = new LinkedList<>();
        B = new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (empty()){
            return null;
        }
        while (A.size() > 1){
            //说明A里面不止一个元素,那么就将A里的元素搬移到B中去
            Integer front = A.poll();//将A中队首元素依次入B
            B.offer(front);
        }
        //循环结束后,说明A中只有一个队尾元素,也就是栈中需要最早出栈的元素
        int ret = A.poll();
        //交换AB,保证A都是入队列的
        swap();
        return ret;
    }

    private void swap() {
        Queue<Integer> temp = A;
        A = B;
        B = temp;
    }
    /** Get the top element. */
    public Integer top() {
        if (empty()){
            return null;
        }
        while (A.size() > 1){
            //说明A里面不止一个元素,那么就将A里的元素搬移到B中去
            Integer front = A.poll();//将A中队首元素依次入B
            B.offer(front);
        }
        //循环结束后,说明A中只有一个队尾元素,也就是栈中需要最早出栈的元素
        int ret = A.poll();
        B.offer(ret);
        //与pop唯一的区别就是,top是返回栈顶元素的值,这个元素还是要保存在栈中的,
        // pop是返回这个元素的值,但是该元素出栈.
        //交换AB,保证A都是入队列的
        swap();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

}
