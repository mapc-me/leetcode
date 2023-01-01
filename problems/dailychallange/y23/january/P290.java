package dailychallange.y23.january;

import java.util.HashMap;
import java.util.Map;

public class P290 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> matchByChar = new HashMap<>();
        Map<String, Character> matchByString = new HashMap<>();

        for (int i = 0; i < pattern.length(); i ++) {
            if (!matchByString.containsKey(words[i])) {
                matchByString.put(words[i], pattern.charAt(i));
            } else if (!matchByString.get(words[i]).equals(pattern.charAt(i))) {
                return false;
            }
            if (!matchByChar.containsKey(pattern.charAt(i))) {
                matchByChar.put(pattern.charAt(i), words[i]);
            } else if (!matchByChar.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }
        }

        return true;

    }
}
