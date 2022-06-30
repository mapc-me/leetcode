package prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P974 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySum(int[] nums, int k) {
        List<Integer> mod = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                mod.add(nums[i] % k);
                continue;
            }
            mod.add((mod.get(i - 1) + nums[i] % k) % k);
        }
        int answer = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        for (int currentMod : mod) {
            int needOne = currentMod > 0 ? currentMod - k : currentMod + k;
            if (currentMod == 0) {
                answer += 1;
            }

            Integer candidateOne = prefixSum.get(currentMod);
            Integer candidateTwo = prefixSum.get(needOne);
            answer += candidateOne == null ? 0 : candidateOne;
            answer += candidateTwo == null ? 0 : candidateTwo;

            if (prefixSum.containsKey(currentMod)) {
                prefixSum.put(currentMod, prefixSum.get(currentMod) + 1);
            } else {
                prefixSum.put(currentMod, 1);
            }
        }
        return answer;
    }
}
