package chap12_DaynamicProgramming;

/**
 * Created by xing on 5/2/17.
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。

 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。

 测试样例：
 "1A2C3D4B56",10,"B1D23CA45B6A",12
 返回：6
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];
    }
}
