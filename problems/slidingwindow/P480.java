package slidingwindow;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P480 {

    public static void main(String[] args) {
//check k = 1
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

//        int[] nums = {1,2,3,4,2,3,1,4,2};
//        int k = 3;
//        int[] nums = { 1,3,-1,-3,5,3,6,7};
//        int k = 4;

//        int[] nums = { 1,3,-1,-3,5,3,6,7};
//        int k = 1;

        int[] nums = {2147483647,2147483647};
        int k = 2;

        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b.compareTo(a));
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> a.compareTo(b));

        double[] ans = new double[nums.length - k + 1];

        final int diff = k % 2;

        for (int i = 0; i < k; i++) {
            if (min.size() == 0 || min.peek() > nums[i]) {
                min.offer(nums[i]);
            } else {
                max.offer(nums[i]);
            }

        }

        while (Math.abs(min.size() - max.size()) > k % 2) {
            rebalance(min, max, diff);
        }

        ans[0] = getAnswer(min, max, k);
        int it = 1;

        for (int i = k; i < nums.length; i++) {
            if (min.contains(nums[i - k])) {
                min.remove(nums[i - k]);
            } else {
                max.remove(nums[i - k]);
            }

            if (min.size() > 0 && min.peek() > nums[i]) {
                min.offer(nums[i]);
            } else {
                max.offer(nums[i]);
            }
            rebalance(min, max, diff);
            ans[it++] = getAnswer(min, max, k);
        }

        return ans;
    }

    private static void rebalance(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int diff) {
        if (min.size() - max.size() > diff) {
            max.offer(min.poll());
        }
        if (max.size() - min.size() > diff) {
            min.offer(max.poll());
        }
    }

    private static double getAnswer(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int k) {
        if (k % 2 == 0) {
            return ((long) (min.peek() + (long)(max.peek()))) / 2d;
        }
        if (max.size() > min.size()) {
            return max.peek();
        }
        return min.peek();
    }
}
