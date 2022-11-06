package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class P930 {

    public static void main(String[] args) {
//        int[] nums = {1,0,1,0,1};
//        int k = 2;

        int[] nums = {0,0,0,0,0};
        int k = 0;


        System.out.println(numSubarraysWithSum(nums, k));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            if (prefix.containsKey(sum - goal)) {
                ans += prefix.get(sum - goal);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }

        System.out.println(prefix);
        return ans;

    }
}
