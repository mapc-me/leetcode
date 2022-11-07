package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Very interesting task for sliding window.
 */
public class P992 {

    public static void main(String[] args) {

        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3,3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
        System.out.println(subarraysWithKDistinct(new int[]{1,1,2,3,3}, 3));
        System.out.println(subarraysWithKDistinct(new int[]{2,2,1,2,2,2,1,1}, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysAtMostK(nums, k) - subarraysAtMostK(nums, k - 1);
    }

    public static int subarraysAtMostK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        int l = 0;
        for (int r = 0; r < nums.length; r ++) {

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(l < nums.length && map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l ++;
            }

            ans += (r - l) + 1;
        }

        return ans;
    }
}
