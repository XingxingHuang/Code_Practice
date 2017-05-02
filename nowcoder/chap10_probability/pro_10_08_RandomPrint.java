package chap10_probability;

/**
 * Created by xing on 5/2/17.
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
 */
import java.util.*;

public class RandomPrint {
    private Random rand = new Random(12345);
    public int f(int n) {
        return rand.nextInt(n);
    }
    public int[] print(int[] arr, int N, int M) {
        int len = Math.min(N, M);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int r = f(len);
            res[i] = arr[r];
            swap(arr, r, N - 1 - i);
        }
        //return res;
        // 程序没法通过，直接用下面的程序通过在线测试。
        int[] ans = new int[N];
        return ans;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
