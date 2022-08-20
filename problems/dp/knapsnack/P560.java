package dp.knapsnack;

import java.util.HashMap;

public class P560 {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            result += prefixSum.getOrDefault(sum - k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
            System.out.println(sum);
        }

        return result;
    }

}
