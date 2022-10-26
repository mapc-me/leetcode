package slidingwindow;

/**
 * pseudo sliding window
 */
public class P2063 {

    public static void main(String[] args) {
//        System.out.println(countVowels("bbaa"));
        System.out.println(countVowels("noosabasboosa"));
    }

    public static long countVowels(String word) {
        long ans = 0;
        long last = 0;
        boolean hasVowel = false;
        int l = 0;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (isVowel(currentChar)) {
                hasVowel = true;
                last += l;
            }

            while (hasVowel) {
                last += 1;
                if (isVowel(word.charAt(l))) {
                    hasVowel = false;
                }
                l++;
            }

            ans += last;
        }

        return ans;

    }

    public static boolean isVowel(char currentChar) {
        return currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'u' || currentChar == 'o';
    }
}
