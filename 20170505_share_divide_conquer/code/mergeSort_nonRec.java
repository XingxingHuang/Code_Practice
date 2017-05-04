public class MergeSort {
    public void Merge(int[] array, int low, int mid, int high) {
        int i = low; 
        int j = mid + 1; 
        int k = 0; 
        int[] array2 = new int[high - low + 1];

        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                array2[k] = array[i];
                i++;
                k++;
            } else {
                array2[k] = array[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            array2[k++] = array[i++];
        }
        while (j <= high) {
            array2[k++] = array[j++];
        }
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = array2[k];
        }
    }

    // 这里用的是非递归的方法
    public void MergePass(int[] array, int gap, int length) {
        int i = 0;
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length) {
            Merge(array, i, i + gap - 1, length - 1);
        }
    }

    public int[] sort(int[] list) {
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            MergePass(list, gap, list.length);
            System.out.print("gap = " + gap + ":\t");
            this.printAll(list);
        }
        return list;
    }

    // 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {
                9, 1, 5, 3, 4, 2, 6, 8, 7
        };
        MergeSort merge = new MergeSort();
        System.out.print("排序前:\t\t");
        merge.printAll(array);
        merge.sort(array);
        System.out.print("排序后:\t\t");
        merge.printAll(array);
    }
}