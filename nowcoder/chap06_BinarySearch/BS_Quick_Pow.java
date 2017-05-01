package chap06_BinarySearch;

/**
 * Created by xing on 4/29/17.
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。

 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。

 测试样例：
 2,3
 返回：8

 注意： 如果这里去余的方式跟题目给的方式不一样，那么最后结果可能不一致。 这个OJ不是很靠谱

 */
import java.util.*;

public class QuickPower {
    public int getPower(int k, int N) {
        // write code here
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return k;
        }
        if (N % 2 == 0) {
            long tmp = getPower(k, N / 2);
            tmp = (tmp * tmp) % 1000000007;
            return (int)tmp;
        }else {
            long tmp = getPower(k, (N - 1) / 2);
            tmp = (tmp * tmp) % 1000000007;
            return (int)((tmp * k) % 1000000007);
        }

    }
}
