package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class P525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter--;
            } else {
                counter++;
            }
            if (!map.containsKey(counter)) {
                map.put(counter, i);
            } else {
                answer = Math.max(answer, i - map.get(counter));
            }
        }
        return answer;
    }
}
