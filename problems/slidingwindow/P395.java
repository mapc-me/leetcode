package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class P395 {
    public static void main(String[] args) {
//        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("aaabb", 2));
//        System.out.println(longestSubstring("baaabcb", 3));
    }

    public static int longestSubstring(String s, int k) {
        Set<Character> unique = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            unique.add(s.charAt(i));
        }

        int ans = 0;
        for (int i = 1; i <= unique.size(); i++) {
            int repeated = 0;
            int[] characters = new int[28];
            int r = 0;
            for (int l = 0; l < s.length(); l++) {
                char lChar = s.charAt(l);

                while (r < s.length() && repeated <= i) {
                    char rChar = s.charAt(r);
                    if (characters[rChar - 'a'] == 0) {
                        if (repeated == i) {
                            break;
                        } else {
                            repeated ++;
                        }
                    }
                    characters[rChar - 'a']++;
                    r++;
                }

                boolean candidate = true;
                for (Integer freq : characters) {
                    if (freq > 0 && freq < k) {
                        candidate = false;
                        break;
                    }
                }
                if (candidate) {
                    ans = Math.max(ans, r - l);
                }
                if (characters[lChar - 'a'] == 1) {
                    repeated--;
                }
                characters[lChar - 'a']--;
            }
        }

        return ans;

    }
}
