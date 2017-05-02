package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * 在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法

 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。

 测试样例：
 2,2
 返回：2
 */
import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
        // write code here
        if (x == 1 && y == 1) {
            return 0;
        }
        int m = x - 1; // 可移动步数
        int n = y - 1;
        int count1 = 1;
        int count2 = 1;
        for (int i = 0; i < m; i++) {
            count1 *= (m + n - i);
            count2 *= i + 1;
        }
        return count1 / count2;
    }
}


// 同学代码中的代码
import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
        int n = x+y-2;
        int m = x-1;
        int res = go(n)/(go(m)*go(n-m));
        return res;
    }

    private int go(int n) {
        int res = 1;
        for(int i=1;i<=n;i++){
            res *= i;
        }
        return res;
    }
}
