package chap04_stack_queue;

/**
 * Created by xing on 4/27/17.
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。

 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。

 测试样例：
 [1,2,3,0,4,0],6
 返回：[1,2]
 */
import java.util.*;

public class TwoStack {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    private boolean sign = true; // true, use stack1.
    public int pop() {
        if (sign) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            sign = !sign;
        }
        return stack2.pop();
    }
    public void push(int num) {
        if (!sign) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            sign = !sign;
        }
        stack1.push(num);
    }
    public int[] twoStack(int[] ope, int n) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int num: ope) {
            if (num > 0) {
                push(num);
            } else {
                list.add(pop());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
