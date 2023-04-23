package grind75.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = (nums[i] + nums[j]) * -1;
                if (map.containsKey(target) && map.get(target) > j) {
                    List<Integer> triplet = Stream.of(nums[i], nums[j], target)
                                                  .sorted(Integer::compareTo)
                                                  .toList();
                    answer.add(triplet);
                }
            }
        }

        return answer.stream().toList();
    }
}
