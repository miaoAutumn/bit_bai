package nowcoder;

public class nowcoder2 {//链表分割
  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
  }
    public class Partition {
        public ListNode partition(ListNode pHead, int x) {
           //先判断是不是空链表
            if (pHead==null){
                return null;
            }
            //判断是否只有一个节点
            if (pHead.next==null){
                return pHead;
            }
            ListNode cur=pHead;
            //思路：创建两个新链表，将大于x的节点尾插bighead。小于x的节点尾插smallhead。
            ListNode bighead=new ListNode(-1);
            ListNode bigtail=bighead;
            ListNode smallhead=new ListNode(-1);
            ListNode smalltail=smallhead;
            for (cur=pHead;cur!=null;cur=cur.next){
                if (cur.val<x){
                    smalltail.next=new ListNode(cur.val);//为了防止链表中.next的影响，
                                      // 故创建一个新的节点，用cur.val进行初始赋值
                                      //新节点的next一定是null
                    smalltail=smalltail.next;
                }else {
                    bigtail.next=new ListNode(cur.val);
                    bigtail=bigtail.next;
                }
            }
            smalltail.next=bighead.next;//有傀儡节点所以指向bighead.next
            return smallhead.next;
        }
    }

}
