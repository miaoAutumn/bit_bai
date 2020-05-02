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



    //猫狗收容所
    public ArrayList<Integer> asylum(int[][] ope) {
    // list用来存储入收容所的猫狗,res用来存储出收容所的动物
    List<int[]> list = new LinkedList<>();
    ArrayList<Integer> res = new ArrayList<>();
    for (int [] i :ope){
        //如果i[0]=1,代表动物进收容所
        if (i[0] == 1){
         list.add(i);
        }
        else if (i[0] == 2) {
            //说明动物要出收容所,有3种情况
            if (i[1] == 0) {
                //采取第一种方式收养,收养最先入收容所的动物不论猫狗
                //前提收容所中有动物
                if (!list.isEmpty()) {
                    int[] animal = list.remove(0);
                    //animal数组中存的就是第一只动物的信息[入还是出,猫还是狗],
                    // 此时下标为1的元素就是动物的身份
                    res.add(animal[1]);
                }
            } else {
                //采取第2,3种收养方式(-1代表收养猫,1代表收养狗)
                for (int j = 0; j < list.size(); j++) {
                    //如果收养猫并且收养所中有猫||收养狗并且收容所里面有狗,
                    // 就将对应的动物出收容所,并添加到res中去
                    if (i[1] == -1 && list.get(j)[1] < 0 || i[1] == 1 && list.get(j)[1] >0){
                   //list.get(j)得到的是对应j下标的list一维数组,
                   // list.get(j)[1],得到的是该一维数组的下标为1的元素
                       int [] animal = list.remove(j);
                       res.add(animal[1]);
                     //已经找到出收容所的动物了,后面的就不需要再判断了
                        break;
                    }
                }
            }
        }
    }
    return res;
    }


   //栈的压入弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
   //先对非法条件进行限制
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length){
            return false;
        }
        int j = 0;
        //遍历pushA元素入栈
        for (int i = 0;i < pushA.length;i++) {
            stack.push(pushA[i]);
            //当栈顶元素等于popA中元素时,则出栈
            //出现了空栈异常,所以要在这里加上空栈判断
            while ( !stack.isEmpty() && stack.peek() == popA[j] ) {
                stack.pop();
                //比较当前栈顶元素和popA的下一个元素
                j++;
            }
        }
        //上循环结束后,若辅助栈为空,则为true,不为空,则返回false
        return stack.isEmpty();
    }


    //逆波兰表达式求值 力扣150
    public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    Integer t1,t2;
    //遍历字符串数组中所有字符串,
    // 如果是运算符则将前两个栈顶元素进行相应运算将结果入栈,如果不是运算符则直接进行压栈操作.
    // 最后栈顶元素即为所求最终值
        for (String s:tokens) {
         if (s .equals( "+")){
           t1 = stack.pop();
           t2 = stack.pop();
           stack.push( t1 + t2);
         }
         else if (s.equals( "-")){
             t1 = stack.pop();
             t2 = stack.pop();
             //这里注意栈顶元素是做减数
             stack.push( t2 - t1);
         }
         else if ( s .equals( "*")){
             t1 = stack.pop();
             t2 = stack.pop();
             stack.push( t1 * t2);
        }
        else if (s.equals( "/")){
             t1 = stack.pop();
             t2 = stack.pop();
             //这里注意栈顶元素是做除数
             stack.push( t2 / t1);
        }
        //非运算符直接入栈
        else {
            //自动拆箱
            stack.push(Integer.parseInt(s));
         }
        }
        return stack.peek();
    }


    //最后一块石头的重量.使用优先级队列来做
    public int lastStoneWeight(int[] stones) {
        //优先级队列默认升序,所以需要重写compare方法
   Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

       @Override
       public int compare(Integer o1, Integer o2) {
           //要降序,所以o2 - o1
           return o2 - o1;
       }
   });
   //遍历数组,将数组元素入队列
        for (int i= 0;i < stones.length;i++){
            queue.offer(stones[i]);
        }
    //模拟比较过程,当队列中只剩一个元素或0个元素时结束比较
       while (queue.size()>1){
          int t1 = queue.poll();//第一大的数
          int t2 = queue.poll();//第二大的数
          if (t1 == t2){
              //t1和t2都不要了,继续查找下两个队首
              continue;
          }
          else {
              //将他两的差值重新入队列,基于优先级队列的排序性,会重新进行降序排序
              int diff = Math.abs(t1 - t2);
              queue.offer(diff);
          }
       }
       return queue.isEmpty()? 0:queue.poll();
    }

    //字符串中第一个唯一字符
    public int firstUniqChar(String s) {
        //k代表字符,V代表出现次数
   Map< Character,Integer> map = new HashMap<>();
   int n = s.length();
   //遍历字符串入map
   for (int i = 0;i<n;i++) {
       char c = s.charAt(i);
       //如果c的值之前没出现过现在是第一次出现,则默认value=0,若之前出现过,则value+1
       Integer index = map.getOrDefault(c, 0);
       map.put(c,index + 1);
   }
       //遍历map查找第一value为1的值
       for ( int i = 0;i<s.length();i++){
           if(map.get(s.charAt(i)) ==1){
               return i;
           }
       }

   return -1;

    }


}
