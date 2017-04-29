package chap05_linkedlist;

/**
 * Created by xing on 4/29/17.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 *
 * 注意：这道题目有两种解法。一种是采用hashtable存储random节点，一种不需要。这里我采用较简单地hashtable的方法。
 * http://www.jiuzhang.com/solutions/copy-list-with-random-pointer/
 */
import java.util.*;
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        Hashtable<RandomListNode, RandomListNode> map = new Hashtable<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode cur = dummy;
        RandomListNode node; // save the new node
        while (pHead != null) {
            // add current node
            if (!map.containsKey(pHead)) {
                node = new RandomListNode(pHead.label);
                map.put(pHead, node);
            } else {
                node = map.get(pHead);
            }
            cur.next = node;
            // add random node
            if (pHead.random != null) {
                if (!map.containsKey(pHead.random)) {
                    node.random = new RandomListNode(pHead.random.label);
                    map.put(pHead.random, node.random);
                } else {
                    node.random = map.get(pHead.random);
                }
            }
            pHead = pHead.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}


// 第二种解法
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {

        if(pHead == null){
            return null;
        }
        // 复制所有节点，放置在原始链表后面
        RandomListNode nod = pHead;
        RandomListNode next = null;
        while(nod != null){
            next = nod.next;
            nod.next = new RandomListNode(nod.label);
            nod.next.next = next;
            nod = next;
        }
        // 复制random节点
        nod = pHead;
        RandomListNode nodCopy;
        while(nod != null){
            next = nod.next.next;
            nodCopy = nod.next;
            nodCopy.random = nod.random != null ? nod.random.next : null;
            nod=next;
        }
        // 整理链表得到结果
        nod = pHead;
        RandomListNode res = pHead.next;
        while(nod != null){
            next = nod.next.next;
            nodCopy = nod.next;
            nod.next = next;
            nodCopy.next = next != null ? next.next : null;
            nod = next;
        }
        return res;
    }
}
