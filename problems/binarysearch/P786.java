package binarysearch;

public class P786 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};

        kthSmallestPrimeFraction(arr, 5);

    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        final int n = arr.length;

        float l = 0f;
        float r = 1f;
        float m = 0f;

        int cnt = 0;

        int index1 = 0;
        int index2 = 0;

        while (true) {
            m = (l + r) / 2;
            cnt = 0;
            index1 = 0;
            index2 = 0;

            for (int i = 0; i < n - 1; i ++) {
                int j = n - 1;
                while (j > i && arr[i] <= m * arr[j]) {
                    j --;
                }
                cnt += n - j - 1;
                // if (index1 / index2 > arr[i] / arr[j])  ->
                if (j < n - 1 && index1 * arr[j + 1] <= arr[i] * index2)  {
                    index1 = arr[i];
                    index2 = arr[j + 1];
                }
            }

            if (cnt == k) {
                return new int[]{index1, index2};
            } else if (cnt > k) {
                r = m;
            } else {
                l = m;
            }
        }
    }
}
