package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P187 {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> faced = new HashMap<>();
        List<String> answer = new ArrayList<>();
        char[] temp = Arrays.copyOf(s.toCharArray(), 10);
        faced.put(new String(temp), 1);

        for (int i = 10; i < s.length(); i++) {

            System.arraycopy(temp, 1, temp, 0, 9);
            temp[9] = s.charAt(i);

            String subDna = new String(temp);
            if (faced.getOrDefault(subDna, 0) == 1) {
                answer.add(subDna);
            }
            faced.put(subDna, faced.getOrDefault(subDna, 0) + 1);
        }

        return answer;
    }
}
