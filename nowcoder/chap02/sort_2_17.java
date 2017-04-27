package chap02;

/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。

 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。

 测试样例：
 [0,1,1,0,2,2],6
 返回：[0,0,1,1,2,2]
 */
import java.util.*;

public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        int i = -1;	// index of 0
        int j = 0;	// index
        int k = A.length - 1; // index of last one
        while (j <= k) {
            if (A[j] == 0) {
                swap(A, i + 1, j);
                i++;
                j++;
            } else if (A[j] == 2) {
                swap(A, j, k);
                k--;
            } else {
                j++;
            }
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
