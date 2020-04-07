package nowcoder;

import bit_bai.LinkList;

public class nowcoder3 {//删除链表中的重复节点，重复节点不保留
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead)
        {
            ListNode cur=pHead;//指向链表的头结点
            ListNode newhead=new ListNode(-1);//创建一个新的链表，给一个傀儡节点
            ListNode newtail=newhead;
          while (cur!=null){//循环链表
              if (cur.next!=null&&cur.val==cur.next.val){//代表是重复节点
                  //注意：要对cur.next进行非空判断
                 while (cur.next!=null&&cur.val==cur.next.val){
                     cur=cur.next;
                 }
                 //循环结束时，cur指向的是重复节点段的最后一个节点
                  //因为重复节点不保留，所以让cur再走一步到下一个新节点
                  cur=cur.next;
              }

              else {//不是重复节点，直接保存在新的链表中，尾插
                  newtail.next=new ListNode(cur.val);//创建一个新的节点，保证他的next是干净的
                  newtail=newtail.next;
                  cur=cur.next;
              }
          }
          return newhead.next;//略过傀儡节点
        }
    }
}
