package other;

import java.util.Arrays;
import java.util.Comparator;

public class P27 {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int ele : nums) {
            if (ele != val) {
                nums[index++] = ele;
            }
        }
        return index;
    }
}
