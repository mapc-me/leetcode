package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {

        private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());
        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        public MedianFinder() {
        }

        // min always more than max
        public void addNum(int num) {
            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }
            if (maxHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if ((Math.abs(maxHeap.size() - minHeap.size()) > 1) || maxHeap.size() < minHeap.size()) {
                balanceHeaps();
            }
        }

        public double findMedian() {
            if (maxHeap.size() == 0 && minHeap.size() == 0) {
                throw new IllegalArgumentException("Empty list");
            }
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2D;
            }
            return maxHeap.peek();
        }

        private void balanceHeaps() {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

}
