package chap06_BinarySearch;

/**
 * Created by xing on 4/29/17.
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。

 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。

 测试样例：
 [1,2,3,3,4],5,3
 返回：2
 */
// 不采用二分法模板编写
import java.util.*;

public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > num) {
                hi = mid - 1;
            } else if (arr[mid] == num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (arr[lo] != num) {
            return -1;
        }
        return lo;
    }
}

// 采用二分法模板编写
import java.util.*;

public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= num) {
                right = mid;
            } else {
                left = mid;  // left is the most likely position;
            }
        }
        if (arr[left] == num) {
            return left;
        } else if (arr[right] == num) {
            return right;
        }
        return -1;
    }
}
