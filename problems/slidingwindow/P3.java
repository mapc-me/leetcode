package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * - Didn't notice constraints
 * - Made a typo
 * - Solved on leetcode (without IDE)
 */
public class P3 {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> chars = new HashSet<>();

        int ans = 0;
        int cur = 0;
        int l = 0;
        int r = 0;
        while (l < s.length()) {
            while (r < s.length()) {
                char currentChar = s.charAt(r);
                if (chars.contains(currentChar)) {
                    break;
                }
                cur++;
                r++;
                chars.add(currentChar);
            }
            ans = Math.max(ans, cur);
            chars.remove(s.charAt(l));
            cur--;
            l++;
        }

        return ans;
    }
}
