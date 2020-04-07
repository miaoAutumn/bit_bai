package bit_bai;
//一个节点
//在Java中，一个.java文件可以存放多个类，
// 但是只能有一个public类，并且这个public类名与文件名相同

//顺序表擅长随机访问，给定下标进行操作
//链表不擅长随机访问，给定下标时还需要遍历操作
//在链表中，除了头插尾插较方便，其余操作均为O（N）
class Node{
    public int data;//一个值
    public Node next=null;//一个低配指针，地址，存放的是下一个节点的位置
    public Node(int data){
        this.data=data;
    }
}
public class LinkList { //管理所有链表的节点，只需要记录头结点的位置即可
    //通常使用一个头结点来代指整个链表
    private Node head = null;

    public void addFirst(int data) {
        //根据data的值构建一个链表节点（Node的值）
        Node node = new Node(data);
        //1.如果是一个空链表
        if (head == null) {
            head = node;
            return;
        }
        //2.如果不是空链表，头插
        node.next = head;
        head = node;
    }

    public void addLast(int data) {//尾插
        //1.根据data构建一个链表节点（Node对象）
        Node node = new Node(data);
        //2.若链表是空链表
        if (head == null) {
            head = node;
            return;
        }
        //3.若链表不是空链表，则先找到尾节点的位置
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        //循环结束，tali就对应最后一个节点
        tail.next = node;
    }

    public void display() {
        //打印整个链表
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();//system什么都不加意味着/n换行
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public boolean addIndex(int index, int data) {
        //任意位置插入
        //判断index是否合法
        int size=getSize();
        if (index < 0 || index > size) {
            //则指index不合法，插入无效，返回false
            return false;
        }
        //2.若index=0，相当于头插
        if (index==0){
            addFirst(data);
            return true;
        }
        //3.若index=size，相当于尾插
        if (index==size){
            addLast(data);
            return true;
        }
        Node node=new Node(data);
        //4.一般情况，index是中间元素
        //在链表中，要插入中间元素就要找到指定位置的前一个位置，让前一个位置指向自身
        //A.要先找到index的前一个位置index-1；
      Node prev=getPos(index-1);
        node.next=prev.next;
        prev.next=node;
       return true;
    }
    //给定一个index值，返回该下标对应的节点
    public Node getPos(int index){
        Node cur=head;
        for (int i=0;i<index;i++){
            //cur.next操作之前必须保证index的值为非null
            cur=cur.next;
        }
        return cur;
    }
    //查找是否有关键字toFind
    public boolean contains(int toFind){
        for (Node cur=head;cur!=null;cur=cur.next){
            if (cur.data==toFind){
               return true;
            }
        }
        return false;
    }
    //删除第一次出现关键字为toFind的值，按值删除
    public void remove(int toFind){
        //1.判断是否为头结点，头结点特殊处理
        if (head.data==toFind){
            head=head.next;
            return;
        }
        //2.若不是头结点，则需要找到删除节点的前一个节点
          Node prev=searchprev(toFind);
        //3.让前一个节点的的指向略过应删除的节点，直接指向后一个节点
//        也可以是prev.next=prev.next.next,但是这么写太丑了
        Node toDelete=prev.next;
        prev.next=toDelete.next;
    }

    public   Node searchprev(int toFind){
        //查找toFind的前一个节点
        //只要是对一个引用（cur）进行.成员变量操作，则这个引用必须是非空引用（非null）
        //所以要关注cur以及cur.next的值要为非null
        for (Node cur=head;cur!=null&&cur.next!=null;cur=cur.next){
            if (cur.next.data==toFind){
                return cur;
            }
        }
        //删除元素不存在，则return null；
        return null;
    }
    public void removeAll(int toRemove){
        //1.删除的值不在头结点，需要找到带删除节点的前一个位置
        //用prev始终指向cur的前一个位置
        Node prev=head;
        Node cur=head.next;
        while (cur!=null){
            if (cur.data==toRemove){
                //说明cur是待删除的节点
                prev.next=cur.next;
                //为了让cur访问下一个节点
                cur=prev.next;
            }
            else {//将cur和prev都向后前进一位
                prev=prev.next;
                cur=cur.next;
            }
        }
        //2.处理删除的值在头结点的情况
        //类似于前面头删
        //将头结点情况放在后面避免头结点的下一个节点仍为待删节点，避免再次循环，
        if (head.data==toRemove){
            head=head.next;
        }
    }
    public void clear(){

        head=null;
    }
}




