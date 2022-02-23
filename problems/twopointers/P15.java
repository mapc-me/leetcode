package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P15 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> numbersCounter = new HashMap<>();

        for (Integer num : nums) {
            numbersCounter.put(num, numbersCounter.getOrDefault(num, 0) + 1);
        }
        List<Integer> uniqNumbers = new ArrayList<Integer>(numbersCounter.keySet());

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < uniqNumbers.size(); i++) {
            Integer first = uniqNumbers.get(i);
            for (int j = i; j < uniqNumbers.size(); j++) {
                Integer second = uniqNumbers.get(j);
                if (first.equals(second) && numbersCounter.get(first) < 2) {
                    continue;
                }
                int currentSum = first + second;
                int needCount = 1;

                if (first == 0 && second == 0) {
                    needCount = 3;
                } else {
                    if (first == (-currentSum)) {
                        needCount++;
                    }
                    if (second == (-currentSum)) {
                        needCount++;
                    }
                }
                Integer free = numbersCounter.getOrDefault(-currentSum, 0);
                if (free >= needCount) {
                    List<Integer> triplet = List.of(first, second, -currentSum).stream().sorted(Integer::compareTo)
                            .collect(Collectors.toList());
                    result.add(triplet);
                }
            }
        }

        return new ArrayList<>(result);
    }



}
