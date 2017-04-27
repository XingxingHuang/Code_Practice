package chap02;
/**
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。

 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。

 测试样例：
 [2,1,4,3,6,5,8,7,10,9],10,2
 返回：[1,2,3,4,5,6,7,8,9,10]
 */

import java.util.*;

public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        // write code here
        k = Math.min(n, k);
        int[] aux = new int[k];
        // copy aux array
        for (int i = 0; i < k; i++) {
            aux[i] = A[i];
        }
        // min heapfy the aux
        for (int i = k / 2; i >= 0; i--) {
            heapAdjust(aux, i, k);
        }
        // loop the aux array
        for (int i = 0; i < n - k; i++) {
            A[i] = aux[0];
            aux[0] = A[i + k];
            heapAdjust(aux, 0, k);
        }
        // loop the left array
        for (int i = n - k; i < n; i++) {
            A[i] = aux[0];
            swap(aux, 0, k - 1);
            k--;
            heapAdjust(aux, 0, k);
        }
        return A;
    }
    public void heapSort(int[] A, int lo, int hi) {
        int len = hi - lo;
        for (int i = lo + len / 2; i < hi; i++) {
            heapAdjust(A, i, hi);
        }
        for (int i = hi - 1; i > 0; i--) {
            swap(A, 0, i);
            heapAdjust(A, 0, i);
        }
    }
    public void heapAdjust(int[] A, int parent, int length) {
        int parent_value = A[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && A[child] > A[child + 1]) {
                child++;
            }
            if (parent_value <= A[child]) {
                break;
            }
            A[parent] = A[child];
            parent = child;
            child = 2 * child  + 1;
        }
        A[parent] = parent_value;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
