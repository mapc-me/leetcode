package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P215 {

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());

        Arrays.stream(nums).forEach(heap::add);
        for (int i = 1; i < k; i ++) {
            heap.poll();
        }
        return heap.poll();
    }
}
