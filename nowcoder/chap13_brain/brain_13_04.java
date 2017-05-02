package chap13_brain;

/**
 * Created by xing on 4/30/17.
 * A与B做游戏。 在一个n*m的矩阵中的出发点是（1，m），终点是（n,1），
 * 规则是只能向左移动一格，向下一格或向左下移动一格，先走到终点的为winner。 A先走。
 * <p>
 * 给定两个整数n和m，请返回最后的获胜者的名字(A或B)。
 * <p>
 * 测试样例：
 * 5 3
 * 返回：B
 *
 * 注：
 * 参考网站的解释： http://blog.5ibc.net/p/64768.html
 * 只有m 和n都是奇数的时候B才能赢
 */
import java.util.*;

public class Game {
    public char getWinner(int n, int m) {
        // write code here
        return (m & 1) == 1 && (n & 1) == 1 ? 'B' : 'A';
    }
}
