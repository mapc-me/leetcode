package heap;

import java.util.PriorityQueue;

public class P1642 {

    public static void main(String[] args) {
        int[] arr = {4,12,2,7,3,18,20,3,19};
        System.out.println(furthestBuilding(arr, 10, 2));

    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;
        for (; i < heights.length - 1; i++) {
            int difference = heights[i + 1] - heights[i];
            if (ladders == 0 && bricks < difference) {
                break;
            }
            if (difference <= 0) {
                continue;
            }
            if (difference <= bricks) {
                bricks -= difference;
                heap.offer(difference);
                continue;
            }
            if (!heap.isEmpty() && heap.peek() > difference) {
                bricks += heap.poll() - difference;
                heap.offer(difference);
            }
            ladders--;
        }

        return i;
    }
}
