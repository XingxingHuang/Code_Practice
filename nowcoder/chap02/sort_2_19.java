package chap02;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。

 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。

 测试样例：
 [1,4,6,5,9,10],6
 返回：2
 */
import java.util.*;

public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        // write code here
        int cur_max = A[0];
        int right = -1;
        int left = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= cur_max) {
                cur_max = A[i];
            } else {
                right = i;
            }
        }
        int cur_min = A[A.length - 1];
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] <= cur_min) {
                cur_min = A[i];
            } else {
                left = i;
            }
        }
        if (left == -1 || right == -1) {
            return 0;
        }
        return right - left + 1;
    }
}
