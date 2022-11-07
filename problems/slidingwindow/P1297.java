package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Could be solved faster!
 */
public class P1297 {

    public static void main(String[] args) {

//        System.out.println(maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maxFreq("aaaa", 2, 1, 3));
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        for (int i = minSize; i <= maxSize; i ++) {

            Map<String, Integer> counter = new HashMap<>();

            int[] letters = new int[26];
            int unique = 0;
            for (int l = 0; l < s.length(); l ++) {
                if (letters[s.charAt(l) - 'a'] == 0) {
                    unique ++;
                }
                letters[s.charAt(l) - 'a'] ++;

                if (l < i - 1) {
                    continue;
                }

                String currentString = s.substring(l - i + 1, l + 1);
                if (unique <= maxLetters) {
                    counter.put(currentString, counter.getOrDefault(currentString, 0) + 1);
                    ans = Math.max(counter.get(currentString), ans);
                }

                letters[s.charAt(l - i + 1) - 'a'] --;
                if (letters[s.charAt(l - i + 1) - 'a'] == 0) {
                    unique --;
                }

            }


        }

        return ans;
    }
}
