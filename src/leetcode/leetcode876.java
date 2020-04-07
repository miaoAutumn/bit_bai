package leetcode;

public class leetcode876 {//返回链表的中间节点
    class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
 }

    public class Solution {
        public ListNode middleNode(ListNode head) {
           //1.判断是否为空链表
            if (head==null){
                return null;
            }
            //2.是否为一个元素
            if (head.next==null){
                return head;
            }
            //3.一般情况
            //返回中间节点，就是让循环走总结点的数的一半
            ListNode cur=head;
            int size=0;
            int steps=getsizes(head)/2;//steps是cur的前进步数
            for (size=0;size<steps;size++){//循环结束时，cur指向所求的中间节点
                cur=cur.next;
            }
            return cur;
        }
        public int getsizes(ListNode head){
            int size=0;
            for (ListNode cur=head;cur!=null;cur=cur.next){
                size++;
            }
            return size;
        }
    }
}
