package chap02_sort;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        // write code here
        int gap = n / 2;
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (A[j] < A[j - gap]) {
                        swap(A, j, j - gap);
                    }
                }
            }
            gap /= 2;
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
