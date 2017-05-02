package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?

 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。

 测试样例：
 2
 返回：1
 */
import java.util.*;

public class CombineByMistake {
    final static int RANGE = 1000000007;
    public int countWays(int n) {
        // write code here
        if (n == 1) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[1] = 0;
        f[2] = 1;
        //f[3] = 2 * f[2];
        for (int i = 3; i <= n; i++) {
            // 第n个信放入第m个信封中，选择有（i - 1）种
            // 第m个信封中的信可以放入第n个信封中，也可以不放入。
            long res = (f[i - 2] + f[i - 1]) % RANGE;
            res = (i - 1) * res % RANGE;
            f[i] = (int) res;
        }
        return f[n];
    }
}
