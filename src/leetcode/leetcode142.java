package leetcode;

public class leetcode142 {//返回链表开始入环的第一个节点
     class ListNode {
     int val;
    ListNode next;
     ListNode(int x) {
      val = x;
       next = null;
     }
 }

    public class Solution {//注意：（数学问题）
                       // 快慢指针的交点到环入口节点的长度等于头结点到环入口的长度
        public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        //1.找到快慢指针的交点
      while (fast!=null&&fast.next!=null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) {//链表是带环的
              break;//结束循环
          }
      }

      //上述循环结束有两种可能，一种是链表带环，交点被记录，一种是不带环。
            // 若不带环，则直接返回null
            if (fast==null||fast.next==null){
                return null;
            }

            //2.让指针cur1从头部出发，cur2从快慢指针交点出发，
            ListNode cur2 = fast;//将快慢指针交点位置记录下来
            ListNode cur1=head;
            // 当cur1与cur2 相遇，则该节点为环入口节点
            while (cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;

        }
    }
}
