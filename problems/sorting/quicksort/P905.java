package sorting.quicksort;

public class P905 {
    public int[] sortArrayByParity(int[] nums) {
        partition(nums);
        return nums;
    }

    public void partition(int[] nums) {
        int i = -1;
        int pivot = nums.length - 1;

        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] % 2 == 0) {
                swap(nums, ++i, j);
            }
        }

        if (nums[pivot] % 2 == 0 && i != pivot) {
            swap(nums, ++i, nums.length - 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
