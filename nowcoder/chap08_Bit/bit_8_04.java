package chap08_Bit;

/**
 * Created by xing on 4/30/17.
 * 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。

 给定两个整数a和b，请返回较大的数。

 测试样例：
 1,2
 返回：2
 */
import java.util.*;

public class Compare {
    public int sig(int c){
        return ((c >>> 31) & 1)== 0 ? 1 : 0;
    }
    public int nsig(int c){
        return sig(c) == 0 ? 1 : 0;
    }
    public int getMax(int a, int b) {
        // write code here
        int c = a - b;
        int sigc = sig(c);
        int nsigc = nsig(c);
        return a * sigc + nsigc * b;
    }
}
