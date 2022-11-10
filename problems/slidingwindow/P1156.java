package slidingwindow;

public class P1156 {

    public static void main(String[] args) {
//        System.out.println(maxRepOpt1("ababa"));
//        System.out.println(maxRepOpt1("aaaaa"));
//        System.out.println(maxRepOpt1("aaabaaa"));
//        System.out.println(maxRepOpt1("ab"));
//        System.out.println(maxRepOpt1("aaabbba"));
//        System.out.println(maxRepOpt1("aaabb"));
        System.out.println(maxRepOpt1("aaabbaaa"));
    }

    public static int maxRepOpt1(String text) {
        int[] allChars = new int[26];
        // int[] currentChar = new int[26];

        for (int i = 0; i < text.length(); i ++) {
            allChars[text.charAt(i) - 'a'] ++;
        }

        StringBuilder reversedString = new StringBuilder(text);

        return Math.max(getMax(text, allChars), getMax(reversedString.reverse().toString(), allChars));

    }

    public static int getMax(String text, int[] allChars) {
        int anchor = 0;
        int ans = 1;

        int l = 0;
        int r = 1;
        int replacement = 0;

        while (r < text.length()) {

            if (text.charAt(r) != text.charAt(l)) {
                if (replacement == 0) {
                    anchor = r;
                }
                replacement++;
            }

            if (r - l + 1 > allChars[text.charAt(l) - 'a'] || replacement > 1) {
                ans = Math.max(ans, r - l);
                r = anchor;
                l = anchor;
                replacement = 0;
            }
            r ++;
        }

        return Math.max(ans, r - l);
    }
}
