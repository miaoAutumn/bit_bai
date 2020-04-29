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
    
    public static void main(String[] args){
        String [] test = {"5","2","C","D","+"};
        StackQueueInterview stackQueueInterview = new StackQueueInterview();
        System.out.println( stackQueueInterview.calPoints(test));

    }
    

}
