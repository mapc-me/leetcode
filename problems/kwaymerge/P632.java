package kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

public class P632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] pointer = new int[nums.size()];

        PriorityQueue<Integer> minIndexHeap = new PriorityQueue<>((a, b) -> {
            if (nums.get(a).get(pointer[a]) < nums.get(b).get(pointer[b])) {
                return -1;
            } else {
                return 1;
            }
        });

        int max = 0;

        for (int i = 0; i < nums.size(); i ++) {
            minIndexHeap.offer(i);
            max = Math.max(nums.get(i).get(0), max);
        }

        int minIndex = minIndexHeap.poll();
        int min = nums.get(minIndex).get(pointer[minIndex]);

        int[] ans = new int[2];
        ans[0] = min;
        ans[1] = max;
        pointer[minIndex]++;

        while (pointer[minIndex] < nums.get(minIndex).size()) {
            minIndexHeap.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(pointer[minIndex]));

            minIndex = minIndexHeap.poll();
            min = nums.get(minIndex).get(pointer[minIndex]);

            if (ans[1] - ans[0] > max - min) {
                ans[0] = min;
                ans[1] = max;
            }

            pointer[minIndex] ++;
        }

        return ans;
    }
}
