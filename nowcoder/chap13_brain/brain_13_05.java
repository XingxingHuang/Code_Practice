package chap13_brain;

/**
 * Created by xing on 4/30/17.
 * 现在有一个整数数组，其元素值均为1-n范围内的某个整数，
 * 现在你和你的朋友在玩一个游戏，游戏的目的是把数组清空，
 * 你们轮流操作，你是先手，每次操作你可以删除数组中值为某个数的元素任意多个
 * (当然数组中值为这个数的元素个数应大于等于你删除的个数,且你至少要删除一个数)。
 * 最先把数组清空的人获得胜利。假设你们都采取最优策略，请你计算你能否获得胜利。
 * <p>
 * 给定一个整数数组A和元素个数n。请返回一个整数，1代表你能获胜，0代表你不能获胜。
 * <p>
 * 测试样例：
 * [1,1,1]
 * 返回：1
 *
 * 注： 参考他人解答。不是很清楚
 */
import java.util.*;

public class Clear {
    public int getWinner(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        int num;
        Arrays.sort(A);
        for(int i = 0; i < n; ++i){
            int j = i;
            num = 0;
            while(j < n && A[i] == A[j]){
                ++num;
                ++j;
            }
            result ^= num;
        }
        return (result == 0) ? 0 : 1;
    }
}
