package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。现在问你满足A的要求的对列有多少种？

 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。

 测试样例：
 6,1,2,3
 288
 */
import java.util.*;

public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        // write code here
        // 用总的排列方法,减去ab相邻,ac相邻再加上abc相邻的情况即可
        return C(n) - 4 * C(n - 1) + 2 * C(n - 2);
    }
    private int C(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }
}
