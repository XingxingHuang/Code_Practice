package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * n个数进出栈的顺序有多少种？假设栈的容量无限大。

 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。

 测试样例：
 1
 返回：1
 */
import java.util.*;

public class Stack {
    public int countWays(int n) {
        // write code here
        return C(2*n, n) / (n + 1);
    }
    public int C(int m, int n) {
        int num = 1;
        int num2 = 1;
        for (int i = 0; i < n; i++) {
            num = num * (m - i);
            num2 = num2 * (n - i);
        }
        return num / num2;
    }
}
