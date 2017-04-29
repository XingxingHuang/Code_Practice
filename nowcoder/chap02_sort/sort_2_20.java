package chap02_sort;

/**
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。

 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。

 测试样例：
 [1,2,5,4,6],5
 返回：2
 */

public class Gap {
    public int maxGap(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = A[0];
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
            if (min > A[i]) {
                min = A[i];
            }
        }
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < A.length; i++) {
            arr[A[i] - min]++;
        }
        int last = 0;
        int count = 0;
        for (int i = 0; i < max - min + 1; i++) {
            if (arr[i] != 0) {
                count = Math.max(count, i - last);
                last = i;
            }
        }
        return count;
    }
}
