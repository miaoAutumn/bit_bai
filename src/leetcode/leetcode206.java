package leetcode;

public class leetcode206 {//反转链表，空间复杂度O（1），时间复杂度O（N）
    class ListNode {//一个节点
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
 }
    class Solution {
        public ListNode reverseList(ListNode head) {
    //1.链表为空链表
            if (head==null){
                return head;
            }
            //2.链表只有一个节点
            if (head.next==null){
                return head;
            }
            //3.一般情况
            ListNode prev=null;//prev始终指向cur的前一个节点，反转后，prev指向null
            ListNode cur=head;
            ListNode newHead=head;
            while (cur!=null){
                //要修改cur.next的值，则需要先将cur.next的值存起来，方便向后移动
                ListNode next=cur.next;
                if(next==null){
                    //next=null，则说明cur已经是最后一个节点了
                    //反转后，cur为头结点
                    newHead=cur;
                }
                cur.next=prev;//反转操作
                //同步更新prev和cur的值，进行下一次反转的准备工作
                prev=cur;
                cur=next;
            }
            return newHead;//返回头结点的值
        }
    }
}
