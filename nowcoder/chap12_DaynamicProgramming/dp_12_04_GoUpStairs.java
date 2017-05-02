package chap12_DaynamicProgramming;

/**
 * Created by xing on 5/2/17.
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 为了防止溢出，请将结果Mod 1000000007
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。

 测试样例：
 1
 返回：1
 */
import java.util.*;

public class GoUpstairs {
    private int CONST = 1000000007;
    public int countWays(int n) {
        // write code here
        int last = 1;
        int cur = 1;
        if (n == 1) {
            return cur;
        }
        for (int i = 1; i < n; i++) {
            int temp = (cur + last) % CONST;
            last = cur;
            cur = temp;
        }
        return cur;
    }
}
