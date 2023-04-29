package grind75.week2;

public class Leetcode76 {
    final int N = 'z' - 'A' + 1;

    public String minWindow(String s, String t) {
        int[] target = new int[N];
        int[] cur = new int[N];

        for (char chr : t.toCharArray()) {
            target[getIndex(chr)] ++;
            cur[getIndex(chr)] ++;
        }

        int l = 0;
        int r = 0;

        final int n = s.length();
        int answerLength = 0;
        int globalL = 0;
        int globalR = 0;
        int size = 0;

        while (l < n) {
            if (target[getIndex(s.charAt(l))] == 0) {
                l ++;
                continue;
            }
            r = Math.max(l, r);
            while (size < t.length() && r < n) {
                if (target[getIndex(s.charAt(r))] > 0) {
                    if (cur[getIndex(s.charAt(r))] > 0) {
                        size ++;
                    }
                    cur[getIndex(s.charAt(r))] --;
                }
                r ++;
            }
            // System.out.println(l + " " + size);


            if (size == t.length()) {
                if ((r - l + 1) < answerLength || answerLength == 0) {
                    answerLength = r - l + 1;
                    globalL = l;
                    globalR = r;
                }
            }

            if (target[getIndex(s.charAt(l))] != 0) {
                cur[getIndex(s.charAt(l))] ++;
                if (cur[getIndex(s.charAt(l))] > 0) {
                    size --;
                }
            }
            l++;
        }

        if (answerLength == 0) {
            return "";
        } else {
            return s.substring(globalL, globalR);
        }
    }

    public int getIndex(char chr) {
        return 'z' - chr;
    }
}
