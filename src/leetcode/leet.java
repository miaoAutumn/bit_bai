package leetcode;

public class leet {//反转链表练习
    class ListNode {//一个节点
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head==null){
            return null;
            }
            if (head.next==null){
                return head;
            }
            ListNode cur=head;
            ListNode prev=null;
            ListNode newHead=head;
            while (cur!=null){
                ListNode next=cur.next;
                if(next==null){
                    newHead=cur;
                }
                cur.next=prev;
                prev=cur;
                cur=next;
            }
            return newHead;
        }
        }



}
