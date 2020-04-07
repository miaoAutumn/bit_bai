package leetcode;

import bit_bai.LinkList;

public class leetcode203 {//删除链表中给定val的所有节点
     class ListNode {//节点
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
    }
 }

 public ListNode removeElements(ListNode head, int val) {
        //1.判断链表是否为空链表
        if (head == null) {
            return null;
        }
        //2.不是头结点的情况
        //prev始终是要删除节点cur的前一个节点
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {//需要删除
                prev.next = cur.next;
                cur = prev.next;
            } else {//不需要删除，则prev和cur都前进一格
                prev = prev.next;
                cur = cur.next;
            }
        }
        //3.删除节点是头结点的情况
        if (head.val == val) {
            head = head.next;
        }
     //对head的值进行更新，但是head仍指头结点
        return head;
    }





}

