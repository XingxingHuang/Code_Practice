package chap04_stack_queue;

/**
 * Created by xing on 4/27/17.
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。

 测试样例：
 [1,2,3,4,5]
 返回：[5,4,3,2,1]
 */
import java.util.*;

public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        int num;
        int i = numbers.length - 1;
        int j = -1;
        while (i >= 0) {
            num = numbers[i--];
            while (j >= 0 && num > list.get(j)) {
                numbers[++i] = list.get(j--);
            }
            j++;
            if (list.size() < j + 1) {
                list.add(num);
            } else {
                list.set(j, num);
            }
        }
        return list;
    }
}



import java.util.*;

public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        int[] stack = new int[numbers.length];
        int num;
        int m = numbers.length - 1; // index of numbers array
        int n = -1; // index of auxiliary stack
        while (m >= 0) {
            num = numbers[m--];
            // cannot push to the stack, but we can pop some firstly.
            while (n >= 0 && num < stack[n]) {
                numbers[++m] = stack[n--];
            }
            stack[++n] = num;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            list.add(stack[i]);
        }
        return list;
    }
}
