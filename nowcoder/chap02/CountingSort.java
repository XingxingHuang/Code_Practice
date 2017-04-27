import java.util.*;

public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        int[] list = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            list[A[i] - min]++;
        }
        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < max - min + 1; i++) {
            while (list[i] != 0) {
                res[index++] = i + min;
                list[i]--;
            }
        }
        return res;
    }
}