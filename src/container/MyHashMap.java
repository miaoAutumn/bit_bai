package container;

public class MyHashMap {
    //开散列，链表，除留余数法
    public static class Node{
        //创建一个链表的节点静态内部类，因为哈希表是hashmap的一个实例，所以是key—value
       private int key;
       private int value;
       public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

     //哈希表的本体，每个元素又是一个链表的头结点，所以是Node类型的
    public Node[] array = new Node[101];
    public int size = 0;//当前的数组元素个数
    private static final double LOAD_FACTOR=0.78;//负载因子，不可变对象。


    //插入操作，在链表中如果key存在就修改当前value的值
    //如果key不存在就插入新的键值对
    public  void put(int key,int value){
    //1.通过哈希函数确定关键码，把key映射成数组下标
        int index = hashFunc(key);
    //2.根据下标找到对应的链表头结点
        Node list = array[index];
    //3.遍历链表查找key是否存在
    for (Node cur = list;cur != null;cur = cur.next){
        if (cur.key==key){
            //说明key值存在，更新value
            cur.value=value;
            return;
        }
        }
        //当循环结束，也没有找到，key值不存在，插入新的键值对
        //此处选择头插，头插简单
        Node newhead = new Node(key,value);
        newhead.next = list;
        array[index] = newhead;
        size++;

        if (loadFactor()>LOAD_FACTOR){
            resize();
        }
        return;
    }

    //扩容操作，把原来hash表中的所有元素搬运到新的数组中
    private void resize() {
        Node [] newarray = new Node [array.length*2];//原来数组的二倍
        for ( int i=0;i<array.length;i++){
            for (Node cur=array[i];cur!=null;cur=cur.next){
                int index = cur.key/newarray.length;
                Node newnode = new Node(cur.key,cur.value);
                newnode.next = newarray[index];
                newarray[index]=newnode;

            }
        }
        //释放原来数组
        array=newarray;

    }


    //查找操作,找到key的值则返回对应的value，没有找到k值则返回-1
    public int get(int key){
        //1.通过哈希函数确定关键码
        int index = hashFunc(key);
        //2.找到对应的链表
        Node list = array[index];
        //3.遍历链表查找是否存在key值
        for (Node cur = list;cur != null;cur = cur.next){
            if (cur.key==key){
                return cur.value;
            }
        }
        //循环结束还没有找到key的值
        return -1;
    }


    //扩容操作，扩容根据负载因子来判断
    private double loadFactor(){
        return size*1.0/array.length;
    }


   //哈希函数，实际工作中会更加复杂
    private  int hashFunc(int key) {
        //简单的除留余数法
        return key%array.length;
    }

}

