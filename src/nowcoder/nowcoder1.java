package nowcoder;
public class nowcoder1 {//输入一个链表，输出这个链表的倒数第k个节点
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode findKthToTail(ListNode head,int k) {
           int size=getsize(head);
     //1.判断是否为空链表
            if (head==null){
                return null;
            }
            //2.判断k是否有效
            if(k<=0||k>size){
                return null;
            }
            //3.返回倒数第k个节点就是让引用走size-k步
            int step=size-k;
            ListNode cur=head;
            for (int i=0;i<step;i++){
                cur=cur.next;
            }
            return cur;
        }
        public int getsize(ListNode head){
         int size=0;
         for (ListNode cur=head;cur!=null;cur=cur.next){
             size++;
         }
         return size;
        }
    }
}
