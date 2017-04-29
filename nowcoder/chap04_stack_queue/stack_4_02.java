package chap04_stack_queue;

/**
 * Created by xing on 4/27/17.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

 */
import java.util.Stack;

public class Solution {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> ministack = new Stack<Integer>();

    public void push(int node) {
        if (ministack.isEmpty() || ministack.peek() >= node) {
            ministack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (ministack.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        if (ministack.peek() == stack.peek()) {
            ministack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (ministack.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return ministack.peek();
    }
}
