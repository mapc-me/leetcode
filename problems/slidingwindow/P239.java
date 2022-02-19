package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class P239 {

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> queueMap = new TreeMap<>(Comparator.reverseOrder());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            queueMap.put(nums[i], queueMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = k - 1; i < nums.length; i++) {
            queueMap.put(nums[i], queueMap.getOrDefault(nums[i], 0) + 1);
            Integer max = queueMap.firstKey();
            result.add(max);
            int prevKey = nums[i - k + 1];
            Integer prevKeyValue = queueMap.get(prevKey);
            if (queueMap.get(prevKey) == 1) {
                queueMap.remove(prevKey);
            } else {
                queueMap.put(nums[i - k + 1], prevKeyValue - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
