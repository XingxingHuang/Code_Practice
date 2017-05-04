public class Quicksort  {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }
    
    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}


public class Quicksort implements Sorter {
    // Sort the array a[0..n-1] by the quicksort algorithm.
    public void sort(Comparable [] a, int n) {
        quicksort(a, 0, n-1);
    }
    private void quicksort(Comparable [] a, int p, int r) {
        if (p < r) {          
            int q = partition(a, p, r); // q is pivot position
            quicksort(a, p, q-1);       
            quicksort(a, q+1, r);       
        }
    }
  
    protected int partition(Comparable [] a, int p, int r) {
        Comparable pivot = a[r];    
        int i = p - 1;           
        for (int j = p; j < r; j++) {   
            if (a[j].compareTo(pivot) <= 0) { 
                i++;                
                swap(a, i, j);         
            }
        }
    
        swap(a, i+1, r);
        return i+1;
    }

    protected void swap(Comparable [] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}