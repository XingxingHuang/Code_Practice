package chap05_linkedlist;

/**
 * Created by xing on 4/29/17.
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。

 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。

 注意：不同情况的相交
 （1） 入环节点前相交
 （2） 入环节点处相交
 （3） 环相交但入环节点不同

 在线评测系统与题意不相符，只需要修改返回值为true或者false即可。

 */
// 通过测试的程序
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        ListNode cur1 = null;
        ListNode cur2 = null;
        // 检查环内是否相交
        if (loop1 != loop2) {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return true;
                }
                cur1 = cur1.next;
            }
            return false;
            // 检查入环前哪里相交
        } else {
            int n1 = getLoopLen(head1, loop1);
            int n2 = getLoopLen(head2, loop2);
            cur1 = n1 > n2 ? head1 : head2;
            cur2 = n1 > n2 ? head2 : head1;
            int n = Math.abs(n1 - n2);
            while (n-- != 0) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return true;
        }

    }
    public int getLoopLen(ListNode head, ListNode loop) {
        int n = 0;
        while (head != loop) {
            n++;
            head = head.next;
        }
        return n;
    }
    public ListNode getLoopNode(ListNode head) {
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
    public ListNode chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        ListNode cur1 = null;
        ListNode cur2 = null;
        // 检查环内是否相交
        if (loop1 != loop2) {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop2;
                }
                cur1 = cur1.next;
            }
            return null;
            // 检查入环前哪里相交
        } else {
            int n1 = getLoopLen(head1, loop1);
            int n2 = getLoopLen(head2, loop2);
            cur1 = n1 > n2 ? head1 : head2;
            cur2 = n1 > n2 ? head2 : head1;
            int n = Math.abs(n1 - n2);
            while (n-- != 0) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }

    }
    public int getLoopLen(ListNode head, ListNode loop) {
        int n = 0;
        while (head != loop) {
            n++;
            head = head.next;
        }
        return n;
    }
    public ListNode getLoopNode(ListNode head) {
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
