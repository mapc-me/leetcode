package sorting.mergeintervals;

public class P88 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = 0;
        int second = 0;
        int[] result = new int[m + n];
        int i = 0;
        while (first < m || second < n) {
            if (first == m) {
                result[i] = nums2[second++];
                i ++;
                continue;
            }
            if (second == n) {
                result[i] = nums1[first++];
                i ++;
                continue;
            }
            if (nums1[first] < nums2[second]) {
                result[i] = nums1[first++];
            } else {
                result[i] = nums2[second++];
            }
            i ++;
        }
        for (int j = 0; j < n + m; j ++) {
            nums1[j] = result[j];
        }
    }
}
