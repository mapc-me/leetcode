package sorting.basic;

public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {55, 15, 95, 23, 117, 87, 6, 10};
        int[] arr = {4, 1, 3, 9, 7};
        quickSort(arr, 0, arr.length - 1);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j ++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, right);
        return i;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int position = partition(arr, left, right);
        quickSort(arr, left, position - 1);
        quickSort(arr, position + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
