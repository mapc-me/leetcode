package slidingwindow;

public class P1248 {

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMostKOddNumbers(nums, k) - atMostKOddNumbers(nums, k - 1);
    }

    public static int atMostKOddNumbers(int[] nums, int k) {
        int ans = 0;
        int odd = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] % 2 == 1) {
                odd++;
            }

            while (l < nums.length && odd > k) {
                if (nums[l] % 2 == 1) {
                    odd --;
                }
                l++;
            }

            ans += (i - l) + 1;
        }

        return ans;

    }
}
