package notes.javase.algorithm.sort;
 
import java.util.Random;
 
public class InsertSort {
 
    public void insertSort(int[] list) {
        // 打印第一个元素
        System.out.format("i = %d:\t", 0);
        printPart(list, 0, 0);
 
        // 第1个数肯定是有序的，从第2个数开始遍历，依次插入有序序列
        for (int i = 1; i < list.length; i++) {
            int j = 0;
            int temp = list[i]; // 取出第i个数，和前i-1个数比较后，插入合适位置
 
            // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
 
            System.out.format("i = %d:\t", i);
            printPart(list, 0, i);
        }
    }
 
    // 打印序列
    public void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
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
        InsertSort insert = new InsertSort();
        System.out.print("排序前:\t");
        insert.printPart(array, 0, array.length - 1);
        insert.insertSort(array);
        System.out.print("排序后:\t");
        insert.printPart(array, 0, array.length - 1);
    }
}