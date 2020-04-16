package container;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMapInterview {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //返回只出现一次的数字
    public int singleNumber(int[] nums) {
        //创建一个map，key是数值，value是出现次数，统计每次出现的个数
        Map<Integer,Integer> map=new HashMap<>();
        //遍历map，如果该数是第一次出现，就将value赋值为1，第二次出现，则将vaule+1；
        for (int x:nums) {
            Integer value=map.get(x);
            if (value==null){
                //说明第一次出现,将value的值设置为1
                map.put(x,1);
            }
            else {//前面已经出现过了,此时的value不是null
                map.put(x,value+1);
            }
        }
        //按照映射关系，打印map中value的key;
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            //此处，用equal（）、表示将1自动装箱成Integer类型，进行比较两个Integer的值
            //如果用==，则表示将Inreger自动拆箱，比较两个int值
            if (entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
     return -1;
    }


  //通过按位异或的方法解决,返回只出现一次的数字
    //a^a=0 ; a^0=a; 所以：a^a^b=b;
    public int singleNumber1(int[] nums) {
        int ret=0;
        //若nums里的值是欧数次，那他就会被还原为0；单数次的数与0异或就为本身
        for (int x:nums) {
           ret= ret^x;
        }
        return ret;
    }



    //复制带随机指针的链表 力扣138
           public Node copyRandomList(Node head) {
               //创建一个map<k,v>，k代表旧节点，v代表复制旧节点得到的新节点
               Map<Node,Node> map=new HashMap<>();
               //1.从头结点出发，遍历链表把旧链表中每个节点依次插入到新map中，
               // 以后就可以通过旧节点（k）找到新节点（V）
               for (Node cur = head;cur != null;cur = cur.next){
                   map.put(cur,new Node(cur.val));
       }
       //2.再次循环修改新链表的指针
       for (Node cur = head; cur != null;cur = cur.next){
           Node newcur = map.get(cur);//根据旧1得到了新1
           newcur.next=map.get(cur.next);
           newcur.random=map.get(cur.random);
       }
       //最终返回新链表头结点，用旧链表查一下
     return map.get(head);
    }


     //宝石与石头 力扣771
    public int numJewelsInStones(String J, String S) {
    //遍历宝石，将宝石放到set中去，
    // 注意，是要看石头里面有多少个宝石，要在石头里找宝石，是将宝石存到set里去
        //comtains（）方法判断的是set里面是否有y对应的元素
        Set<Character> set = new HashSet<>();
        //toCharArray(),将字符串变为数组
        for (char x:S.toCharArray()){
            set.add(x);
        }
        //再遍历石头，判断石头是否在set（宝石）中出现，拿着石头跟宝石对比，看出现几次
        int ret=0;
        for (char y:J.toCharArray()){
           if (set.contains(y)){
               ret++;
           }
        }
        return ret;
    }



    public static void main(String[] args){
        SetMapInterview setMapInterview = new SetMapInterview();
        int [] array = {2,7,9,2,9,7,1};
        System.out.println(setMapInterview.singleNumber(array));
    }


}
