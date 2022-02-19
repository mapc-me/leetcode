package sorting.cyclicsort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P268 {

    public static void main(String[] args) {
        int[] sum = {3, 0, 1};
        System.out.println(missingNumber(sum));
    }

    public static int missingNumber(int[] nums) {
        int currentSum = Arrays.stream(nums).sum();
        int expectedSum = IntStream.range(0, nums.length + 1).sum();
        return expectedSum - currentSum;
    }
}
