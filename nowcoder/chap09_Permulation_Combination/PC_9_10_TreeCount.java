package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * 求n个无差别的节点构成的二叉树有多少种不同的结构？

 给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。

 测试样例：
 1
 返回：1
 */
import java.util.*;

public class TreeCount {
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
