package other;

import java.util.HashMap;
import java.util.Map;

public class P1763 {

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }

    public static String longestNiceSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i ++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j ++) {
                Character chr = s.charAt(j);
                map.put(chr, map.getOrDefault(chr, 0) + 1);
                boolean ok = true;
                for (Character c : map.keySet()) {
                    if (!map.containsKey(Character.toUpperCase(c)) || !map.containsKey(Character.toLowerCase(c))) {
                        ok = false;
                    }
                }
                if (ok) {
                    if (j - i + 1 > max) {
                        l = i;
                        r = j;
                        max =  j - i + 1;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
