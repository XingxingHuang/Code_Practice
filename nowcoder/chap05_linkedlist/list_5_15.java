package chap05_linkedlist;

/**
 * Created by xing on 4/29/17.
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。

 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。


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
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 != null && loop2 !=null) {
            if (loop1 == loop2) {
                return true;
            } else {
                return checkLoop(loop1, loop2);
            }
        } else if (loop1 == null || loop2 == null) {
            return false;
        } else {
            return (getLast(head1) == getLast(head2));
        }
    }
    public boolean checkLoop(ListNode loop1, ListNode loop2) {
        // 检查循环链表内部是否相交
        ListNode cur = loop1.next;
        while (cur != loop1) {
            if (cur == loop2) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public ListNode getLast(ListNode head) {
        // 获得单链表最后一个节点
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    public ListNode getLoopNode(ListNode head) {
        // 获得循环链表进入循环的位置。
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
