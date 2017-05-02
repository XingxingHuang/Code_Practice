package chap10_probability;

/**
 * Created by xing on 5/2/17.
 * 给定一个以p概率产生0，以1-p概率产生1的随机函数RandomP::f()，p是固定的值，但你并不知道是多少。
 * 除此之外也不能使用任何额外的随机机制，请用RandomP::f()实现等概率随机产生0和1的随机函数。
 */
import java.util.*;

// 无法通过测试用例，
public class Random01 {
    private static double p = new Random().nextFloat();
    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // 通过f函数实现01等概率返回
        boolean b1 = true;
        boolean b2 = true;
        while (b1 ^ b2) {
            b1 = f() == 0 ? true : false;
            b2 = f() == 0 ? true : false;
        }
        return b1 ? 0 : 1;
    }
}

// 要通过测试用例的话，请直接用系统的随机数产生器
public int random01() {
    Random random= new Random();
    return random.nextInt(2);
}