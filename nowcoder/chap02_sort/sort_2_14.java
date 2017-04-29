package chap02_sort;

/**
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。

 给定一个int数组A及它的大小n，请返回它是否有重复值。

 测试样例：
 [1,2,3,4,5,5,6],7
 返回：true
 */

public class Checker {
    public  boolean checkDuplicate(int[] a, int n) {
        if (a == null || n == 0) {
            return false;
        }
        heapSort(a);
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public  void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i != 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

//    public  void heapSort(int[] arr) {
//        for (int i = 0; i != arr.length; i++) {
//            heapInsert(arr, i);
//        }
//        for (int i = arr.length - 1; i != 0; i--) {
//            swap(arr, 0, i);
//            heapify(arr, 0, i);
//        }
//    }

//    public  void heapInsert(int[] arr, int index) {
//        while (index != 0) {
//            int parent = (index - 1) / 2;
//            if (arr[parent] < arr[index]) {
//                swap(arr, parent, index);
//                index = parent;
//            } else {
//                break;
//            }
//        }
//    }

    public  void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public  void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
