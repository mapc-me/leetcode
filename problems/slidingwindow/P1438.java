package slidingwindow;

import java.util.TreeMap;

public class P1438 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 1};
        System.out.println(longestSubarray(arr, 0));
    }

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int l = 0;
        int r = 0;
        int curAnswer = 0;
        int answer = 0;

        while (l < nums.length) {
            Integer currentNum = nums[l];

            if (map.isEmpty()
                    || (Math.abs(map.firstKey() - currentNum) <= limit
                    && Math.abs(map.lastKey() - currentNum) <= limit)) {
                curAnswer++;
                if (answer < curAnswer) {
                    answer = curAnswer;
                }
                if (map.containsKey(currentNum)) {
                    map.put(currentNum, map.get(currentNum) + 1);
                } else {
                    map.put(currentNum, 1);
                }
                l++;
            } else {
                curAnswer--;
                Integer prevNum = nums[r];
                if (map.get(prevNum) > 1) {
                    map.put(prevNum, map.get(prevNum) - 1);
                } else {
                    map.remove(prevNum);
                }
                r++;
            }
        }

        return answer;
    }
}
