package chap05_linkedlist;

/**
 * Created by xing on 4/28/17.
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。

 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。

 测试样例：
 {1,4,2,5},3
 {1,2,4,5}
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
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        // 为原始链表建立dummy节点
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        // 为大于值的链表建立dummy节点
        ListNode dummyMax = new ListNode(-1);
        ListNode large = dummyMax;
        while (head != null) {
            if (head.val > val) {
                // 移动大于值的链表
                large.next = head;
                large = large.next;
                // 处理小于值的链表
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        large.next = null;
        pre.next = dummyMax.next;
        return dummy.next;
    }
}
