package heap;

import java.util.PriorityQueue;

public class P1438 {

    public static void main(String[] args) {
        int[] arr = {10,1,2,4,7,2};
        System.out.println(longestSubarray(arr, 5));
    }

    public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        int left = 0;
        int right = 0;
        int ans = 0;
        while (left < nums.length && right < nums.length) {
            while (right < nums.length) {
                if (maxHeap.size() < 1) {
                    maxHeap.offer(nums[right]);
                    minHeap.offer(nums[right]);
                    right++;
                    ans++;
                    continue;
                }
                maxHeap.offer(nums[right]);
                minHeap.offer(nums[right]);
                int max = maxHeap.peek();
                int min = minHeap.peek();
                right++;
                ans++;
                if (Math.abs(max - min) > limit) {
                    ans--;
                    break;
                }
            }
            maxHeap.remove(nums[left]);
            minHeap.remove(nums[left]);
            left++;
        }

        return ans;
    }
}
