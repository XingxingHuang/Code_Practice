import java.util.*;

public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        // write code here
        for (int i = n / 2; i >= 0; i--) {
            heapAdjust(A, i, A.length);
        }
        for (int i = A.length - 1; i > 0; i--) {
            swap(A, 0, i);
            heapAdjust(A, 0, i);
        }
        return A;
    }
    public void heapAdjust(int[] A, int parent, int length) {
        int parent_value = A[parent];
        //int left = 2 * parent + 1;
        //int right = 2 * parent + 2;
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && A[child] < A[child +1]) {
                child++;
            }
            if (parent_value >= A[child]) {
                break;
            }
            A[parent] = A[child];
            parent = child;
            child = 2 * child + 1;
        }
        A[parent] = parent_value;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}