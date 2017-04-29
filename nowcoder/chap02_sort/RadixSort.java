package chap02_sort;

public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        // write code here
        int max = getMax(A);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(A, exp);
        }
        return A;
    }
    public int getMax(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        return max;
    }
    public void countSort(int[] A, int exp) {
        int[] ans = new int[A.length];
        int[] count = new int[10];
        for (int i = 0; i < A.length; i++) {
            count[(A[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            ans[count[(A[i] / exp) % 10] - 1] = A[i];
            count[(A[i] / exp) % 10]--;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = ans[i];
        }
    }
}
