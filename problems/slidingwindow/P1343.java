package slidingwindow;

public class P1343 {

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        System.out.println(numOfSubarrays(arr, 3, 4));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int j = 0;
        int ans = 0;
        for (int i = 0; i < arr.length - k + 1; i ++) {
            while (j - i < k) {
                sum += arr[j];
                j ++;
            }
            if (sum / k >= threshold) {
                ans ++;
            }

            sum -= arr[i];
        }
        return ans;
    }
}
