package dailychallange.y22.december;

public class P451 {
    public String frequencySort(String s) {
        final int N = 'z' - '0' + 1;
        final char largestChar = '0';

        int[] counter = new int[N];
        int uniqueChars = 0;

        for (char chr : s.toCharArray()) {
            if (counter[chr - largestChar] == 0) {
                uniqueChars++;
            }
            counter[chr - largestChar] ++;
        }

        int max = 0;
        char[] ans = new char[s.length()];
        int z = 0;

        for (int i = 0; i < uniqueChars; i ++) {
            int index = -1;

            for (int j = 0; j < N; j ++) {
                if (max < counter[j]) {
                    index = j;
                    max = counter[j];
                }
            }

            int begin = z;
            for (; z < begin + max; z ++) {
                ans[z] = (char) (index + largestChar);
            }
            max = 0;
            counter[index] = 0;
        }

        return new String(ans);

    }
}
