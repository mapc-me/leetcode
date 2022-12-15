package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class P119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        prev.add(1);

        for (int i = 2; i <= rowIndex; i ++) {
            int last = 1;
            for (int j = 1; j < prev.size(); j ++) {
                int a_j = prev.get(j);
                prev.set(j, last + prev.get(j));
                last = a_j;
            }
            prev.add(1);
        }

        return prev;


    }
}
