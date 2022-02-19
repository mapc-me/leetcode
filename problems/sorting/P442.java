package sorting;

import java.util.ArrayList;
import java.util.List;

public class P442 {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDuplicates(nums));

    }

    public static List<Integer> funnySolution(int[] nums) {
        int hack = 1_000_000;
        int max_hack = 2_000_000;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i] - 1;
            if (currentNum >= max_hack) {
                currentNum -= max_hack;
            } else if (currentNum >= hack) {
                currentNum -= hack;
            }
            nums[currentNum] += hack;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max_hack) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = Math.abs(nums[i]) - 1;
            if (nums[currentNum] < 0) {
                result.add(currentNum + 1);
            } else {
                nums[currentNum] *= -1;
            }
        }

        return result;
    }
}
