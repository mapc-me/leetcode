package binarysearch;

public class P1539 {
    public int findKthPositive(int[] arr, int k) {

        int l = 0;
        int r = arr.length - 1;

        while (r >= l) {
            int mid = (r + l) / 2;
            if (arr[mid] - mid - 1 < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l + k;
    }
}
