package chap02_sort;

public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int size = m + n;
        m--;
        n--;
        for (int i = size - 1; i >= 0; i--) {
            if (n < 0) {
                A[i] = B[m--];
            } else if (m < 0) {
                //return A;
                A[i] = A[n--];
            } else if (A[n] > B[m]) {
                A[i] = A[n--];
            } else {
                A[i] = B[m--];
            }
        }
        return A;
    }
}
