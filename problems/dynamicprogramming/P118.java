package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j <= i - 1; j++) {
                list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            list.add(1);
            ans.add(list);
        }

        return ans;

    }
}
