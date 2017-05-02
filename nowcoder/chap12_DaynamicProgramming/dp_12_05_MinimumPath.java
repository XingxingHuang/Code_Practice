package chap12_DaynamicProgramming;

/**
 * Created by xing on 5/2/17.
 * 有一个矩阵map，它每个格子有一个权值。
 * 从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。

 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.

 测试样例：
 [[1,2,3],[1,1,1]],2,3
 返回：4
 */
import java.util.*;

public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        // write code here
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - 1 == 0) {
                    dp[i][j] = map[i - 1][j - 1] + dp[i - 1][j];
                } else if (i - 1 == 0){
                    dp[i][j] = map[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = map[i - 1][j - 1] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}

// 讨论区的算法
import java.util.*;

public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        // write code here
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = 0;
            }
        }
        dp[0][0] = map[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] += map[i][0] + dp[i-1][0];
        }
        for(int i = 1; i < m; i++){
            dp[0][i] += map[0][i] + dp[0][i-1];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
