package binarysearch;

public class P744 {
    public char nextGreatestLetter(char[] letters, char target) {
        return binarySearch(letters, target);
    }

    public char binarySearch(char[] letters, char target) {
        int l = 0;
        int mid;
        int r = letters.length;

        while (l < r) {
            mid = (l + r) / 2;
            if (letters[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return letters[l % letters.length];
    }
}
