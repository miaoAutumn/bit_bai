package container;

import java.util.*;

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
        Set<Character> set = new HashSet<>();
        //toCharArray(),将字符串变为数组
        for (char x:S.toCharArray()){
            set.add(x);
        }
        //再遍历石头，判断石头是否在set（宝石）中出现，拿着石头跟宝石对比，看出现几次
        int ret=0;
        for (char y:J.toCharArray()){
            //comtains（）方法判断的是set里面是否有y对应的元素
           if (set.contains(y)){
               ret++;
           }
        }
        return ret;
    }



    //自制比较器
      static class MyComparator implements Comparator<String>{
        //比较字符出现的次数，即比较map的value值。需要将map传过来
        Map<String,Integer> map = new HashMap <>();

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            //通过get（）得到o1，o2两者的vaule值，也就是出现次数
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1==count2){
                //说明两者次数相同，则通过字典顺序进行比较
                //string自身也实现了Comparable，自带字典序的比较功能
                //此处的compareTo是String自带的默认比较器
                return o1.compareTo(o2);
            }
          //比较器的返回规则是：
            // o1>o2,返回>0，
            // o1<o2,返回小于0，
            // o1=o2，返回0
            //此处我们要求降序，所以count2-count1；
            //sort方法就是按照升序排的（小的在前，大的在后）
            //count1-count2，代表次数少的在前
            //count2-count1代表次数多的在前
            //这里重新定义大小前后
            return count2-count1;
        }
    }
    //前k个高频单词，力扣692
    public List<String> topKFrequent(String[] words, int k) {
        //1.将字符串和出现次数存入map中
        //key表示字符串，value表示出现次数
        Map<String,Integer> map = new HashMap<>();
        for (String s:words){
            //将字符串循环入map，若之前没有存入则返回默认value=0;
            // 若之前出现过则value+1；
           Integer index = map.getOrDefault(s,0);
           map.put(s,index+1);
        }
        //2.将刚才统计好的字符串内容放在ArrayList中
        //keyset（）方法得到的是一个set，set里面存放的是所有kye也就是所有字符串
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
         //3.按照刚才字符串出现的次数，按照降序对字符进行排序
        // 可以直接使用标准库中的排序操作，但是标准库中的sort是默认按照字符串升序排列的（string的字典顺序）
        //这里我们要求降序，所以要通过自制比较器来比较
        Collections.sort(arrayList,new MyComparator(map));
        //subList（），截取0到k
      return arrayList.subList(0,k);
    }


    public static void main(String[] args){
        SetMapInterview setMapInterview = new SetMapInterview();
        int [] array = {2,7,9,2,9,7,1};
        System.out.println(setMapInterview.singleNumber(array));
    }


}
