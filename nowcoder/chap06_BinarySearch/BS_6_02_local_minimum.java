package chap06_BinarySearch;

/**
 * Created by xing on 4/29/17.
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class Solution {
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < arr[mid + 1] ) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        if (arr[i] < arr[i + 1]) {
            return i;
        }
        return j;
    }
}
