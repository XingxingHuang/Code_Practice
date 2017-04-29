package chap04_stack_queue;

/**
 * Created by xing on 4/28/17.
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。

 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。

 测试样例：
 [3,1,4,2],4
 返回：[2,0,-1,2]

 解题注释：
    1. MaxTree是一颗二叉树，数组的每个值对应的一个二叉树节点
    2. 包括MaxTree树在内且在其中的每一颗子树上，值最大的节点都是树节点
 解题思路：
    找出每个元素左右第一个大的数，然后将其中较校的数作为父节点建立MaxTree
    题目要求返回数组，每个元素为父亲节点编号，因此只需要找到每个节点的父节点即可。找每个点父节点的时候需要用到栈结构。
 */
import java.util.*;

public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        // write code here
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        // 找到左边大于该值的下标
        for (int i = 0; i < A.length; i++) {
            // 栈中元素值必须top < bottom
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // 找到左右两边大于该值中较小的那个的下标。
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            // 当前找不到最右边的第一个大于的值的时候，即stack 为空时，直接采用左边找到比它大值的下表。
            // stack非空时，如果左边没有较大值，或者右边找到更小值，更新数组。
            if (!stack.isEmpty() && (res[i] == -1 || A[stack.peek()] < A[res[i]]) ){
                // 找到左右两边中较小那个值的下标
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
