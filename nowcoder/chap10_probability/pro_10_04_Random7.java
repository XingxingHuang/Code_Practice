package chap10_probability;

/**
 * Created by xing on 5/2/17.
 * 给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，
 * 请实现等概率随机产生1~7的随机函数。(给定一个可调用的Random5::random()方法,可以等概率地随机产生1～5的随机函数)
 *
 * 注意： 提问区的回复
 * 其实这道题左神没有讲清楚本质，这道题本质就是得到一串均匀分布且长度大于7的连续序列即可
 * （甚至都不需要连续，只要保证能产生7个以上等概率的数即可），在这个序列里选中7个（或7的倍数个），
 * 若得到的数不是这7个中的，重新产生。这样这7个数的概率肯定是相同的。
 * 举例
 * int num = 5 * rand5() + rand5();      //生成6~25的数，选取其中7~20这14个数，非这14个数重新生成，最后取余即可
 * while(num > 20 || num < 7){
 *      num = 5 * rand5() + rand5();
 * }
 * return num % 7 + 1;
 */
import java.util.*;

public class Random7 {
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }

    // 通过rand5实现rand7
    public int randomNumber() {
        int num = 30;
        while (num > 20) {
            num = 5 * (rand5() - 1) + (rand5() - 1);
        }
        return num % 7 + 1;
    }
}
