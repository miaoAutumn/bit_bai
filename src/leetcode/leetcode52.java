package leetcode;

public class leetcode52 { //返回两个链表的第一个公共节点
    public class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
     val = x;
    next = null;
   }
 }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1.先求出两个链表的长度差值，让长的链表先走差值步
            int size1=getsize(headA);
            int size2=getsize(headB);
            int Dvalue=0;
            //让长的链表现先走差值步
            if (size1>size2){
                Dvalue=size1-size2;
                for (int i=0;i<Dvalue;i++){
                    headA=headA.next;
                }
            }
            else{
                Dvalue=size2-size1;
                for (int i=0;i<Dvalue;i++){
                    headB=headB.next;
                }
            }
            ListNode cur1=headA;
            ListNode cur2=headB;
            //2.比较两个节点是否为同一个节点
            while (cur1!=null&&cur2!=null){
                if (cur1==cur2){//该节点为相交节点
                    return cur1;
                }
                cur1=cur1.next;
                cur2=cur2.next;
            }//循环结束后没有相交节点则意味这两个链表无相交返回null
            return null;

        }
        public int getsize(ListNode head){
            int size=0;
            ListNode cur=head;
            for (cur=head;cur!=null;cur=cur.next){
                size++;
            }
            return size;
        }
    }

}
