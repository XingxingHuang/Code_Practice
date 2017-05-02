package chap12_DaynamicProgramming;

/**
 * Created by xing on 5/2/17.
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。

 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。

 测试样例：
 [1,2,4],3,3
 返回：2
 */

import java.util.*;

// 没有优化的dp方法
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        int[][] dp = new int[penny.length][aim + 1];
        dp[0][0] = 1;
        for (int i = 0; i < aim + 1; i++) {
            if (i % penny[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < aim + 1; j++) {
                if (j < penny[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i][j - penny[i]] + dp[i - 1][j];
                }
            }
        }
        return dp[penny.length - 1][aim];
    }
}

// 优化后的dp方法
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        int[] dp = new int[aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            if (i % penny[0] == 0){
                dp[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                if (j >= penny[i]) {
                    dp[j] += dp[j - penny[i]];
                }
            }
        }
        return dp[aim];
    }
}