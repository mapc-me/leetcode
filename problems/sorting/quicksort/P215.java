package sorting.quicksort;

public class P215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] > pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, right);
        return i;
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        int position = partition(nums, left, right);
        if (position == k) {
            return nums[position];
        }
        if (position > k) {
            return quickSort(nums, left, position - 1, k);

        } else {
            return quickSort(nums, position + 1, right, k);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
