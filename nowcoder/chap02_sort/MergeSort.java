import java.util.*;

public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        // write code here
        mergeS(A, 0, A.length - 1);
        return A;
    }
    public void mergeS(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeS(A, start, mid);
        mergeS(A, mid + 1, end);
        mergeArray(A, start, mid, end);
    }
    public void mergeArray(int[] A, int start, int mid, int end) {
        int[] B = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                B[index++] = A[left++];
            } else {
                B[index++] = A[right++];
            }
        }
        while (left <= mid) {
            B[index++] = A[left++];
        }
        while (right <= end) {
            B[index++] = A[right++];
        }
        for (int i = 0; i <= end - start; i++) {
            A[start + i] = B[i];
        }
    }
}