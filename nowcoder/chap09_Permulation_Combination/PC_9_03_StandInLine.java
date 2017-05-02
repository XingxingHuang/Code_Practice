package chap09_Permulation_Combination;

/**
 * Created by xing on 5/1/17.
 * n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？

 给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。

 测试样例：
 7,1,2
 返回：[2520,720]
 */
import java.util.*;

public class StandInLine {
    public int[] getWays(int n, int a, int b) {
        // write code here
        int num1 = 1;
        int num2 = 1;
        for (int i = 0; i < n; i++){
            num1 *= i + 1;
        }
        num1 /= 2;
        num2 = num1 / n * 2;
        return new int[] {num1, num2};
    }
}
