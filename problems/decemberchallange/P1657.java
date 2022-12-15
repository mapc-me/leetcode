package decemberchallange;

import java.util.Arrays;

public class P1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        final int N = 28;
        int[] chars1 = new int[N];
        int[] chars2 = new int[N];

        for (int i = 0; i < word1.length(); i ++) {
            chars1[word1.charAt(i) - 'a'] ++;
            chars2[word2.charAt(i) - 'a'] ++;
        }


        for (int i = 0; i < N; i ++) {
            if (chars1[i] == chars2[i]) {
                continue;
            }

            if (chars1[i] == 0 || chars2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < N; i ++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }

        return true;
    }
}
