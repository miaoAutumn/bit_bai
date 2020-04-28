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



}
