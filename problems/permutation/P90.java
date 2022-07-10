package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        subsets.add(List.of(nums[0]));

        int prevNewIndex = 1;
        int currentNum, size;
        for (int i = 1; i < nums.length; i++) {
            currentNum = nums[i];
            size = subsets.size();
            if (nums[i] == nums[i - 1]) {

                for (int j = prevNewIndex; j < size; j++) {
                    List<Integer> current = new ArrayList<>(subsets.get(j));
                    current.add(currentNum);
                    subsets.add(current);
                }
            } else {
                for (int j = 0; j < size; j++) {
                    List<Integer> current = new ArrayList<>(subsets.get(j));
                    current.add(currentNum);
                    subsets.add(current);
                }
            }
            prevNewIndex = size;
        }

        return subsets;
    }
}
