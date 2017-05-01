package chap06_BinarySearch;

/**
 * Created by xing on 4/29/17.
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。

 给定有序数组arr及它的大小n，请返回所求值。

 测试样例：
 [-1,0,2,3],4
 返回：2
 */
import java.util.*;

public class Find {
    public int findPos(int[] arr, int n) {
        // write code here
        int lo = 0;
        int hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= mid) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (arr[lo] == lo) {
            return lo;
        } else if (arr[hi] == hi) {
            return hi;
        }
        return -1;
    }
}
