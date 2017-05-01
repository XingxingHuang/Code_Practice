package chap06_BinarySearch;

/**
 * Created by xing on 4/29/17.
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。

 给定数组arr及它的大小n，请返回最小值。

 测试样例：
 [4,1,2,3,3],5
 返回：1
 */

import java.util.*;

public class MinValue {
    public int getMin(int[] arr, int n) {
        // write code here
        if (arr == null) {
            return Integer.MAX_VALUE;
        }
        int lo = 0;
        int hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[lo] < arr[hi]) {
                return arr[lo];
            } else if (arr[lo] <= arr[mid]) { //  注意这里必须考虑等号情况。
                lo = mid; // 这里可以是lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (arr[lo] < arr[hi]) {
            return arr[lo];
        }
        return arr[hi];
    }
}