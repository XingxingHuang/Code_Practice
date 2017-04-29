package chap04_stack_queue;

/**
 * Created by xing on 4/27/17.
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。

 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。

 测试样例：
 [4,3,2,1],4
 返回：[1,2,3,4]
 */
import java.util.*;

public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        if (A == null || n == 1) {
            return A;
        }
        int last = getLast(A, n);
        reverseStack(A, n - 1);
        A[n - 1] = last;
        return A;
    }
    public int getLast(int[] A, int n) {
        int num = A[n - 1];
        n--;
        if (n == 0) {
            return num;
        }
        int bottom = getLast(A, n);
        A[n - 1] = num;
        return bottom;
    }
}
