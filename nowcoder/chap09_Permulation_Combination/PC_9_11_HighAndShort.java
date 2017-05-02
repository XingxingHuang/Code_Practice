package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * 12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？

 给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。

 测试样例：
 1
 返回：1
 */
import java.util.*;

public class HighAndShort {
    public int countWays(int n) {
        // write code here
        return C(n, n / 2) / (n / 2 + 1);
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
