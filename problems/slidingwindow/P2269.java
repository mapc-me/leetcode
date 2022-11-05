package slidingwindow;

public class P2269 {

    public int divisorSubstrings(int num, int k) {

        int copy = num;
        int delimeter = 1;

        for (int i = 0; i < k; i ++) {
            delimeter *= 10;
        }


        int answer = 0;
        while (copy >= delimeter / 10) {
            int newInt = copy % delimeter;
            if (newInt > 0 && num % newInt == 0) {
                answer ++;
            }

            copy /= 10;
        }

        return answer;

    }
}
