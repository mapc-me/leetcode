package prefixsum;

public class P2222 {
    public long numberOfWays(String s) {
        int rightZeros = 0;
        int rightOnes = 0;
        int leftOnes = 0;
        int leftZeros = 0;
        long answer = 0;

        for (int i = 0; i < s.length() / 2; i ++) {
            if (s.charAt(i) == '1') {
                leftOnes ++;
            } else {
                leftZeros ++;
            }

            if (s.charAt(s.length() - i + 1) == '1') {
                rightOnes ++;
            } else {
                rightZeros++;
            }
        }


        for (int i = 0; i < s.length() - 1; i ++) {
            if (s.charAt(i) == '0') {
                answer += leftOnes * rightOnes;
                leftZeros++;
                rightZeros--;
            } else {
                answer += leftZeros * rightZeros;
                leftOnes++;
                rightOnes--;
            }
        }

        return answer;

    }
}
