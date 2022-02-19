package sorting;

import java.util.ArrayList;
import java.util.List;

public class P448 {

    public static void main(String[] args) {
        int[] nums = {1,1};

        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = Math.abs(nums[i]) - 1;
            if (nums[currentNumber] > 0) {
                nums[currentNumber] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;

    }
}
