package homeworks;

class Node{//单链表
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
        int size;
        Node head;//头结点
        /** Initialize your data structure here. */
        public MyLinkedList() {
         size = 0;
         head = new Node(-1);//傀儡节点
        }

        public int getSize(){
            int size = 0;
            for (Node cur = head;cur != null;cur = cur.next){
                size++;
            }
           return size;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            //如果所给index值不合法,则返回-1
            if (index < 0 || index >= getSize()){
                return -1;
            }
       //走index+1步,因为有傀儡节点,找到第index+1位置的节点返回其val
            Node cur = head;
            for (int i = 0;i<index+1;i++){
            cur = cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
        //将val值头插到链表中
        int index = 0;
       Node toadd = new Node(val);
       //因为有傀儡节点,所以不会有空指针异常
         toadd.next = head.next;
         head.next = toadd;
        }
        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
         //将val尾插到链表中去
           Node toadd = new Node(val);
           Node cur = head;
           //循环找最后一个节点
            for (cur = head;cur != null;cur = cur.next){

            }
            //循环结束后,cur就是最后一个节点
            cur.next = toadd;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            //在index位置添加val值得节点
            //先对非法条件进行限制
            if (index >= getSize()){
                return;
            }
            if (index < 0){
                index = 0;
            }
            Node pre = head;
            Node toadd = new Node(val);
            for (int i = 0;i<index-1;i++){
                pre = pre.next;
            }
            //循环结束后,pre就指向待插入位置结点的前一个节点
            toadd.next = pre.next;
            pre.next = toadd;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
        //链表删除直接通过.next跳过要删除节点即可
            if (index < 0 || index >= getSize()){
                return;
            }
         Node pre = head;
         for (int i = 0;i < index;i++){
             pre = pre.next;
         }
         //循环结束后pre就指向要删除节点的前一个节点,删除pre,next
            pre.next = pre.next.next;
        }
    }



