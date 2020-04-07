package nowcoder;

import bit_bai.LinkList;

public class nowcoder4 {//链表的回文结构，空间复杂度为O（N）

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class PalindromeList {
        public boolean chkPalindrome(ListNode A) {
            //1.找到A链表的中间节点
            int step = getsize(A) / 2;
            ListNode B = A;
            for (int i = 0; i < step; i++) {
                B = B.next;
            }
            //for循环结束后，B就是A的中间节点
            //2.逆置后半部分链表也就是B链表
            ListNode cur = B;
            ListNode prev = null;//prev始终指向cur的前一个节点，逆置后头结点会变成null
            while (cur != null) {
                ListNode next = cur.next;//每次循环要更改cur.next的值，所以先提前储存
                if (cur.next == null) {//证明cur已经是最后一个节点的
                    //反转后，cur指向头结点
                    B = cur;
                }
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            //3.分别从头比较AB两个链表的值
            while (B != null) {//若链表长度是奇数个节点，则限定无所谓，
                // 若链表长度是偶数个节点，则A比B多一个元素，
                //  则以B！=null作为循环结束的条件，因为B短
                if (A.val != B.val) {
                    return false;
                }
                A = A.next;
                B = B.next;
            }
            return true;

        }

        public  int getsize(ListNode head) {
            ListNode cur = head;
            int size = 0;
            for (cur = head; cur != null; cur = cur.next) {
                size++;
            }
            return size;
        }
    }
}
