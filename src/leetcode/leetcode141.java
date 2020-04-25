package leetcode;

public class leetcode141 {//判断链表是否有环
            class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
     }
 }
    public class Solution {
        public boolean hasCycle(ListNode head) {
       ListNode fast=head;
       ListNode slow=head;
       while(fast!=null&&fast.next!=null){//两个判断条件，防止链表无环
           fast=fast.next.next;//快指针走两步
           slow=slow.next;//慢指针走一步
           if (fast==slow){//快慢指针相遇则一定有环
               return true;
           }
       }
       return false;

        }
    }
}
