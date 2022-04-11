package twopointers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P680 {
    public static void main(String[] args) {
        List<String> data = Stream.of(
                "abcba", "adbba", "adbсba", "adbсba", "abbsa", "abbssa", "av", "a", "abbb", "aabbb", "abc", "aaaddddddd",
                "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu"
        ).collect(Collectors.toList());

        data.forEach(s -> System.out.println(s + " " + validPalindrome(s)));
//        System.out.println(validPalindrome("aaaddddddd"));
    }

    public static boolean validPalindrome(String s) {
        boolean isPalindrome = true;

        int r = 0;
        int l = s.length() - 1;
        while (r < l) {
            if (s.charAt(r) != s.charAt(l)) {
                isPalindrome = checkPalindrome(s.substring(r, l)) || checkPalindrome(s.substring(r + 1, l + 1));
                break;
            }
            r ++;
            l --;
        }

        return isPalindrome;
    }

    private static boolean checkPalindrome(String s) {
        int r = 0;
        int l = s.length() - 1;
        while (r < l) {
            if (s.charAt(r) != s.charAt(l)) {
                return false;
            }
            r++;
            l--;
        }
        return true;
    }
}
