package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。

 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。

 测试样例：
 10,3
 返回：36
 */
import java.util.*;

public class Distribution {
    public int getWays(int n, int m) {
        // write code here
        int ans = 1;
        for(int i = 1; i < m; ++i){
            ans = ans * (n - i) / i;
        }
        return ans;
    }
}
