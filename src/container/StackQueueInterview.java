package container;
import java.util.*;

public class StackQueueInterview {

    //有效的括号 力扣20
    public boolean isValid(String s) {
    //用栈可以解决多层括号的嵌套问题
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        char [] chars = s.toCharArray();
        for (int i = 0;i<chars.length;i++){
            //1.依次遍历字符串,如果是左括号则入栈
            if (chars[i] == '('|| chars[i] == '['||chars[i] == '{'){
                stack.push(chars[i]);
                continue;//取下一个字符
            }
            //如果当前元素已经是右括号了,但是当前栈里元素为空,
            // 则意味着这个右括号没有相对应的左括号,则不合法
            if (stack.empty()){
             return  false;
            }
            //2.如果是右括号,则取栈顶元素和当前右括号进行匹配
            //如果为空栈,取栈顶元素就会报错,所以要先进行是否为空栈判断
            Character top = stack.pop();
            //若匹配,则遍历下一个元素,若不匹配,则代表整体括号匹配不成功为False
            //用if else的圈复杂度较高,可以借助map
//            if (chars[i] == ')' && top == '('){
//                continue;
//            }
//            if (chars[i] == ']' && top == '['){
//                continue;
//            }
//            if (chars[i] == '}'&& top == '{'){
//                continue;
//            }
            if (map.get(top) == chars[i]){
                continue;
            }
            //如果上述合法情况都不满足,则意味着不合法
          return false;
        }
        //若所有字符串均遍历结束,如果栈为空,则表示true,若栈中还有元素就意味不合法.
        if (stack.empty()){
            return true;
        }
        return false;
    }


    //比较含有退格的字符串 力扣844
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
        }
    private String build(String s) {
        //因为处理S,T字符串的操作一样,所以放在一个单独的辅助方法中
        char [] charA = s.toCharArray();
        Stack<Character> A = new Stack<>();
        //循环将S中的元素按要求入栈
        for (int i = 0;i < charA.length;i++){
            if (charA[i] != '#'){
                A.push(charA[i]);
            }
            //考虑A##B的情况,防止空栈出栈顶元素
            else if (A.isEmpty()){
                continue;
            }
            else {
                A.pop();
            }
        }
     return String.valueOf(A);
    }


    //棒球比赛 力扣682
    public int calPoints(String[] ops) {
   //只有C一个操作是删除操作,其余操作都可看成是一个数的累计过程
   // 用栈来存储有效元素,模拟积分过程
        Stack<Integer> stack = new Stack<>();
        //循环遍历字符串入栈,按计分原则入栈
        for (int i = 0;i<ops.length;i++){
            if (ops[i].equals( "D")){
             //前一轮有效得分就是栈顶元素
             Integer temp  = stack.peek();
             Integer value = temp *2;
             stack.push(value);
            }
           else if (ops[i].equals("+")){
            //取前两个栈顶元素,记录第一个的值出栈,再记录第二个值,再将第一个入栈,再将新元素入栈
                int temp = stack.pop();
                int temp2 = stack.peek();
                int value = temp + temp2;
                stack.push(temp);
                stack.push(value);
            }
           else if (ops[i].equals("C")){
               //将栈顶元素出栈
                stack.pop();
            }
            else {
                stack.push(Integer.valueOf(ops[i]));
            }

        }
        int sum = 0;
       for (int i : stack){
          sum+=i;
       }
       return sum;
    }


    //最近请求次数
    Queue<Integer> queue = new LinkedList<>();
    public int ping(int t) {
    queue.offer(t);
        //利用队列的先进先出特点,当队首调用时间不在3000以内,就出队列,直到满足要求
    while (queue.peek() < t -3000){
       queue.poll();
    }
    //队列长度就是3000以内调动的次数
        return queue.size();
    }


    //约瑟夫问题II
    public int getResult(int n) {
        // n代表游戏的人数。请返回最后一个人的编号
        // write code here
  //因为涉及到较多的删除插入操作,所以选用链表来做
        List<Integer> list = new LinkedList<>();
        //将1-n个元素依次存入链表中,下标从1开始存,为了下标和元素一一对应
        for (int i = 1;i < n+1 ;i++){
            list.add(i);
        }
        //初始情况下步长为2:12121212....报数
        int steps = 2;
        //依次遍历链表中的元素,当数组只剩1个元素时停止遍历
        // 模拟报数,当其取余步长不为0时,就将其值改为-1.意味着其为要删除元素
        while (list.size() > 1){
            for (int i = 1; i < list.size();i++){
                if (i%steps != 0){
                    list.set(i,-1);
                }
            }
            //上面的for循环结束代表当前步数模拟报数结束,删除非1元素
            //在遍历链表并删除元素时,
            // 迭代器允许遍历过程中删除元素,而for循环是不可以会报错的,所以这里删除元素需要用迭代器
            Iterator<Integer> iterable = list.iterator();
            while (iterable.hasNext()){
                if (iterable.next() == -1){
                    iterable.remove();
                }
            }
            //调整新的步数123,123,123.....
           steps = steps+1;
            //将链表最后一个元素搬移到链表头部,模拟从最后一人开始报数
              ((LinkedList<Integer>) list).addFirst(list.get( list.size()-1));
              //删除最后一个元素,因为已经放到头部了
             list.remove( list.size()-1);
        }
        //当循环结束后,剩下的唯一一个1就会被搬移到链表的最前面,返回他即可
        int num = list.get(1);
        return num;
    }


    public static void main(String[] args){
        String [] test = {"5","2","C","D","+"};
        StackQueueInterview stackQueueInterview = new StackQueueInterview();
        System.out.println( stackQueueInterview.calPoints(test));

    }
    

}
