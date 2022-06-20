package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class P219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(nums[i])) {
                if (i - index.get(nums[i]) <= k) {
                    return true;
                }
            }
            index.put(nums[i], i);
        }
        return false;
    }
}
