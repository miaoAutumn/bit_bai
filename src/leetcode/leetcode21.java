package leetcode;

public class leetcode21 {//合并两个有序链表
     class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
     }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //若任意一链表为空，合并后即为另一个链表
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        //创建一个新的链表用来存储合并链表
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode newHead=new ListNode(-1);//创建一个傀儡节点，方便代码实现所引用的对象
        ListNode newtail=newHead;//将每次尾插的节点位置存储起来，避免多次循环
        while (cur1!=null&&cur2!=null) {
            if (cur1.val < cur2.val) {
                newtail.next = cur1;
                newtail = newtail.next;
                //当tail指向新链表的最后一个节点时，cur1需要再向后前进一步
                cur1=cur1.next;
            } else {
                newtail.next = cur2;
                newtail = newtail.next;
                cur2=cur2.next;
            }
        }
          if (cur1==null){
              newtail.next=cur2;
          }
          else {
              newtail.next=cur1;
          }

        return newHead.next;//含有傀儡节点，所以要返回newHead.next
        }
    }
}
