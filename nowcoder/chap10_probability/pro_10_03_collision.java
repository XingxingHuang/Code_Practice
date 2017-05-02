package chap10_probability;

/**
 * Created by xing on 5/2/17.
 * n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？

 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。

 测试样例：
 3
 返回：[3,4]
 */
import java.util.*;

public class Ants {
    public int[] collision(int n) {
        // write code here
        long total = 1;
        for (int i = 0; i < n; i++) {
            total *= 2;
        }
        return new int[] {(int) total/2 - 1, (int) total/2};
    }
}
