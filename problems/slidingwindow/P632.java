package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P632 {

    public static void main(String[] args) {
        Integer[][] arr = {
            { 4, 10, 15, 24, 26 },
            { 0, 9, 12, 20 },
            { 5, 18, 22, 30 }
        };



        List<List<Integer>> nums = new ArrayList<>();
        for (Integer[] a : arr) {
            nums.add(Arrays.asList(a));
        }

        System.out.println(smallestRange(nums));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        int[] pointer = new int[nums.size()];

        PriorityQueue<Integer> minList = new PriorityQueue<>((a, b) -> {
            if (nums.get(a).get(pointer[a]) > nums.get(b).get(pointer[b])) {
                return 1;
            } else {
                return -1;
            }
        });
        int max = 0;

        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            minList.offer(i);
        }

        boolean first = true;
        int[] answer = new int[2];

//        pointer[minList.poll()] ++;

        while (true) {
            int currentMinIndex = minList.poll();
            int currentMinValue = nums.get(currentMinIndex).get(pointer[currentMinIndex]);
            if (answer[0] == -1) {
                answer[0] = currentMinValue;
                answer[1] = max;
            } else {
                if (first
                    || (answer[1] - answer[0] == max - currentMinValue && currentMinValue < answer[0])
                    || (max - currentMinValue < answer[1] - answer[0])
                ) {
                    answer[0] = currentMinValue;
                    answer[1] = max;
                    first = false;
                }
            }
            pointer[currentMinIndex]++;
            if (nums.get(currentMinIndex).size() == pointer[currentMinIndex]) {
                return answer;
            }

            max = Math.max(max, nums.get(currentMinIndex).get(pointer[currentMinIndex]));
            minList.offer(currentMinIndex);
        }
    }
}
