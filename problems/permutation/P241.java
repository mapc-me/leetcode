package permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class P241 {

    private static final Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> result = new ArrayList<>();
        if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
            result.add(Integer.valueOf(expression));
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar != '+' &&  currentChar != '-' && currentChar != '*') {
                continue;
            }
            List<Integer> leftPart = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightPart = diffWaysToCompute(expression.substring(i + 1));

            for (Integer left : leftPart) {
                for (Integer right : rightPart) {
                    if (currentChar == '-') {
                        result.add(left - right);
                    } else if (currentChar == '+') {
                        result.add(left + right);
                    } else {
                        result.add(left * right);
                    }
                }
            }
        }
        map.put(expression, result);
        return result;
    }
}
