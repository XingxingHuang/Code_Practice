package chap08_Bit;

/**
 * Created by xing on 4/30/17.
 * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。

 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。

 测试样例：
 [1,2,4,4,2,1,3,5],8
 返回：[3,5]
 */
import java.util.*;

public class OddAppearance {
    public int[] findOdds(int[] arr, int n) {
        // write code here
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        int bit = 1;
        while (((num >> bit) & 1) != 1) {
            bit++;
        }
        int num1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> bit) & 1) == 1) {
                num1 = num1 ^ arr[i];
            }
        }
        int num2 = num ^ num1;
        int[] result = {Math.min(num1, num2), Math.max(num1, num2)};
        return result;
    }
}
