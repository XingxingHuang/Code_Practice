package chap10_probability;

/**
 * Created by xing on 5/2/17.
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？

 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数

 测试样例：
 4
 返回：[3,7]
 */
import java.util.*;

public class Championship {
    public int[] calc(int k) {
        // write code here
        // 总数为 (2k - 1) * (2k - 3) * ... * 1
        // 相遇为 C(k - 1, k + 1) * A(k - 1, k - 1)
        int sum = 1;
        int a = 1;

        //求总的组合数
        for(int i = 2 * k - 1; i > 0; i -= 2){
            sum *= i;
        }

        //强队不相遇 C(k+1,k-1)
        for(int i = 3; i <= k + 1; i++){
            a *= i;
        }

        int gcd = gcd(sum, a);
        sum = sum / gcd;
        a = a / gcd;

        // int[]res = new int[] {sum - a, sum};
        return new int[] {sum - a, sum};


    }

    public int gcd(int a,int b){
        // 分子分母化简，用辗转相除法进行求解。 辗转相除法是古希腊求两个正整数的最大公约数的，也叫欧几里德算法，
        // while (b > 0){
        //     int t = b;
        //     b = a % b;
        //     a = t;
        // }
        return b > 0 ? gcd(b, a % b) : a;
    }
}
