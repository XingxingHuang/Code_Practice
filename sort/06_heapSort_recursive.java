public class testHeapSort {
    public static int[] HeapSort(int[] a, int j){
        // max heap and move max to the end
        for (int i = a.length - 1 - j; i >= 0; i--) {
            if (a[i] > a[i / 2]) {
                swap(a, i, i / 2);
            }
        }
        swap(a, 0, a.length - 1 - j);
        j++;
        // max heap for the rest 
        if(j < a.length) {
            HeapSort(a, j);
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {3,2,4,5,4,9,7,8};
        int j = 0;
        a = HeapSort(a, j);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}


