package container;

import java.util.Stack;

public class MinStack {
    //最小栈问题,要求时间复杂度O(1),所以只能用空间换取时间
    //创建AB两个栈,A 栈用来正常存放元素,B中用来同步更新A 中的最小值
    Stack<Integer> A ;
    Stack<Integer> B;
    public MinStack() {
   A = new Stack<>();
   B = new Stack<>();
    }
    //入队列,A中正常入,B中更新最小值,始终让最小值为B的栈顶元素
    public void push(int x) {
    A.push(x);
    //如果B为空,那么最小值一定就是新加入的x
    if (B.isEmpty()){
        B.push(x);
        return;
    }
    //如果B不为空,那么就取出当前的最小值,也就是当前栈顶元素
        // 将x与当前栈顶元素进行比较,谁小谁当栈顶
        int min = B.peek();
        if (x < min){
        min = x;
        }
        //将最小值入B,此时栈顶元素就是最小值
        B.push(min);
    }
    //出栈,AB要同时出栈,把元素删除就行了
    public void pop() {
        if (A.isEmpty()){
            return;
        }
         A.pop();
         B.pop();
    }
   //取栈顶元素
    public Integer top() {
    if (A.isEmpty()){
        return null;
    }
     return A.peek();
    }
   // 返回最小值,就是B的栈顶元素
    public Integer getMin() {
   if (A.isEmpty()){
       return null;
   }
   return B.peek();
    }
}
