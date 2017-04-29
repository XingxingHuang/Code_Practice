package chap02_sort;

/**
 * Created by xing on 4/25/17.
 */
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }
}
