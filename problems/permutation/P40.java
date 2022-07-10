package permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P40 {
    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> subsets = new LinkedList<>();
        subsets.add(new ArrayList<>());

        for (Integer num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i ++) {
                List<Integer> currentSubset = subsets.poll();

                for (int j = 0; j <= currentSubset.size(); j ++) {
                    List<Integer> newSubset = new ArrayList<>(currentSubset);
                    if (j == currentSubset.size()) {
                        newSubset.add(num);
                    } else {
                        newSubset.add(j, num);
                    }
                    subsets.add(newSubset);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!subsets.isEmpty()) {
            result.add(subsets.poll());
        }

        return result;

    }
}
