package chap05_linkedlist;

/**
 * Created by xing on 4/29/17.
 * 请编写一个函数，检查链表是否为回文。

 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。

 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false


 注意：此题有多重解法，空间复杂度有区别
 （1）用栈结构记录所有节点。然后一次比较。O(N)
 （2）快慢指针找到链表中点，然后比较。O(N/2)
 （3）快慢指针找到链表中点，然后后半逆序，然后判断。

 https://www.nowcoder.com/study/vod/1/5/4
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
// 方法1
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode cur = pHead;
        Stack<Integer> stack = new Stack<Integer>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            if (stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}

// 方法2
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow.val);
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
