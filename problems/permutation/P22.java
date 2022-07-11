package permutation;

import java.util.ArrayList;
import java.util.List;

public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        rec(result, "", n, n);
        return result;
    }

    public void rec(List<String> result, String currentValue, int open, int closed) {
        if (open == closed && open == 0) {
            result.add(currentValue);
            return;
        }
        if (open == closed) {
            rec(result, currentValue + "(", open - 1, closed);
        } else {
            if (open > 0) {
                rec(result, currentValue + "(", open - 1, closed);
            }
            if (closed > 0) {
                rec(result, currentValue + ")", open, closed - 1);
            }
        }
    }

}
