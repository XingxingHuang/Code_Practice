package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * 2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。

 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。

 测试样例：
 1
 返回：1
 */
import java.util.*;

public class BuyTickets {
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
