package heap;

import java.util.*;

public class P895 {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

    private static class FreqStack {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Entity> heap = new PriorityQueue<>((a, b) -> {
            if (a.getCurrentFrequency() == b.getCurrentFrequency()) {
                return b.getOrder() - a.getOrder();
            }
            return b.getCurrentFrequency() - a.getCurrentFrequency();
        });
        int counter = 0;

        public FreqStack() {
        }

        public void push(int val) {
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
            heap.offer(new Entity(val, frequencyMap.get(val), counter++));
        }

        public int pop() {
            if (heap.isEmpty()) {
                throw new IllegalArgumentException("No data in stack");
            }
            Integer result = heap.poll().value;
            Integer frequency = frequencyMap.get(result);
            if (frequency == 1) {
                frequencyMap.remove(result);
            } else {
                frequencyMap.put(result, frequency - 1);
            }
            return result;
        }

        private static class Entity {
            private final int value;
            private final int currentFrequency;
            private final int order;

            public Entity(int value, int currentFrequency, int order) {
                this.value = value;
                this.currentFrequency = currentFrequency;
                this.order = order;
            }

            public int getOrder() {
                return order;
            }

            public int getValue() {
                return value;
            }

            public int getCurrentFrequency() {
                return currentFrequency;
            }
        }
    }
}
