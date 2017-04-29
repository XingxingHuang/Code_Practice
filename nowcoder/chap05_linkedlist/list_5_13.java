package chap05_linkedlist;

/**
 * Created by xing on 4/29/17.
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。

 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。

 注意： 只需要查看最后一个节点是否相同即可。
 */
import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        // write code here
        if (headA == null || headB == null) {
            return false;
        }
        ListNode cur1 = headA;
        while (cur1.next != null) {
            cur1 = cur1.next;
        }
        ListNode cur2 = headB;
        while (cur2 != null) {
            cur2 = cur2.next;
        }
        return cur1 == cur2;
    }
}
