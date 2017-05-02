package chap13_brain;

/**
 * Created by xing on 4/30/17.
 * 作为一个马场的主人，你要安排你的n匹赛马和另一个马场的n匹马比赛。
 * 你已经知道了对方马场的出战表，即参加每一场的马的强壮程度。
 * 当然你也知道你自己的所有马的强壮程度。我们假定比赛的结果直接由马的强壮程度决定，
 * 即更壮的马获胜(若相同则双方均不算获胜)，请你设计一个策略，使你能获得尽量多的场次的胜利。
 * <p>
 * 给定对方每场比赛的马的强壮程度oppo及你的所有马的强壮程度horses
 * (强壮程度为整数，且数字越大越强壮)同时给定n，请返回最多能获胜的场次。
 * <p>
 * 测试样例：
 * [1,2,3],[1,2,3],3
 * 返回：2
 */

import java.util.*;

public class HorseRace {
    public int winMost(int[] oppo, int[] horses, int n) {
        // write code here
        int i = 0;
        int j = 0;
        int count = 0;
        Arrays.sort(oppo);
        Arrays.sort(horses);
        while (i < n && j < n) {
            if (oppo[i] < horses[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}