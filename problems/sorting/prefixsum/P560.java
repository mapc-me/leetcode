package sorting.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class P560 {


    public static void main(String[] args) {
//        int[] nums = {1, -1, 0};
//        int k = 0;
//        int[] nums = {1, 2, 3};
//        int k = 3;
        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounter = new HashMap<>();

        prefixSumCounter.put(0, 1);
        int result = 0;
        int prefixSum = 0;
        for (Integer current : nums) {
            prefixSum += current;
            int prefixSumToFind = prefixSum - k;
            result += prefixSumCounter.getOrDefault(prefixSumToFind, 0);
            prefixSumCounter.put(prefixSum, prefixSumCounter.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}
