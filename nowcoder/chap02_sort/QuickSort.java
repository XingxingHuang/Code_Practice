import java.util.*;

public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        // write code here
        sort(A, 0, n - 1);
        return A;
    }
    public void sort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = A[start + (end - start) / 2];
        while (i <= j) {
            while (A[i] < pivot) {
                i++;
            }
            while (A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        sort(A, start, j);
        sort(A, i, end);
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}