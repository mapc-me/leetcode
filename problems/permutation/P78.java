package permutation;

import java.util.ArrayList;
import java.util.List;

public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());

        for (Integer num : nums) {
            int size = sets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(sets.get(i));
                newList.add(num);
                sets.add(newList);
            }
        }

        return sets;

    }
}
