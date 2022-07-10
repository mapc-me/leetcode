package permutation;

import java.util.ArrayList;
import java.util.List;

public class P784 {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                continue;
            }
            int n = result.size();
            for (int j = 0; j < n; j++) {
                char[] charArr = result.get(j).toCharArray();
                if (Character.isUpperCase(charArr[i])) {
                    charArr[i] = Character.toLowerCase(charArr[i]);
                } else {
                    charArr[i] = Character.toUpperCase(charArr[i]);
                }

                result.add(String.valueOf(charArr));
            }
        }

        return result;
    }
}
