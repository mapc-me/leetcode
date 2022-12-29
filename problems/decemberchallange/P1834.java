package decemberchallange;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1834 {

    public static void main(String[] args) {

        int[][] arr = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
//        int[][] arr = {{7,10},{7,12},{7,5},{7,4},{7,2}};
//        int[][] arr = {{1, 2}, {2, 4}, {3, 2}, {4, 1},{5, 1},{6, 1}};
//        int[][] arr = {{10,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(getOrder(arr)));

    }

    public static class Triad {
        public int time;
        public int processingTime;
        public int index;

        public Triad(int time, int processingTime, int index) {
            this.time = time;
            this.processingTime = processingTime;
            this.index = index;
        }
    }

    public static int[] getOrder(int[][] tasks) {
        Triad[] triads = new Triad[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            triads[i] = new Triad(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(triads, (a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;
            }
            return b.processingTime - a.processingTime;
        });

        PriorityQueue<Triad> heap = new PriorityQueue<>((a, b) -> {
            if (a.processingTime != b.processingTime) {
                return a.processingTime - b.processingTime;
            }
            return a.index - b.index;
        });

        int[] answer = new int[tasks.length];

        int time = 0;
        int i = 0;
        int index = 0;
        while (i < triads.length) {
            if (heap.isEmpty()) {
                time = Math.max(time, triads[i].time);
            }
            while (i < tasks.length && triads[i].time <= time) {
                heap.offer(triads[i]);
                i++;
            }
            Triad min = heap.poll();
            time += min.processingTime;
            answer[index++] = min.index;
        }

        while (!heap.isEmpty()) {
            answer[index++] = heap.poll().index;
        }

        return answer;

    }
}
