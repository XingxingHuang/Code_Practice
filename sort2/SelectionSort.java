package notes.javase.algorithm.sort;
 
import java.util.Random;
 
public class SelectionSort {
 
    public void selectionSort(int[] list) {
        // 需要遍历获得最小值的次数
        // 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
        for (int i = 0; i < list.length - 1; i++) {
            int temp = 0;
            int index = i; // 用来保存最小值得索引
 
            // 寻找第i个小的数值
            for (int j = i + 1; j < list.length; j++) {
                if (list[index] > list[j]) {
                    index = j;
                }
            }
 
            // 将找到的第i个小的数值放在第i个位置上
            temp = list[index];
            list[index] = list[i];
            list[i] = temp;
 
            System.out.format("第 %d 趟:\t", i + 1);
            printAll(list);
        }
    }
 
    // 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        // 初始化一个随机序列
        final int MAX_SIZE = 10;
        int[] array = new int[MAX_SIZE];
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = random.nextInt(MAX_SIZE);
        }
 
        // 调用冒泡排序方法
        SelectionSort selection = new SelectionSort();
        System.out.print("排序前:\t");
        selection.printAll(array);
        selection.selectionSort(array);
        System.out.print("排序后:\t");
        selection.printAll(array);
    }
 
}