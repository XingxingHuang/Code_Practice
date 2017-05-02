package chap13_brain;

/**
 * Created by xing on 4/30/17.
 * 你要在一个nxm的格子图上涂色，你每次可以选择一个未涂色的格子涂上你开始选定的那种颜色。
 * 同时为了美观，我们要求你涂色的格子不能相邻，也就是说，不能有公共边，
 * 现在问你，在采取最优策略的情况下，你最多能涂多少个格子？
 * <p>
 * 给定格子图的长n和宽m。请返回最多能涂的格子数目。
 * <p>
 * 测试样例：
 * 1,2
 * 返回：1
 */

import java.util.*;

public class Paint {
    public int getMost(int n, int m) {
        // write code here
        // 间隔着涂颜色。每次最多只能涂一半。
        return (m * n + 1) / 2;
    }
}
