package slidingwindow;

public class P2024 {

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
    }


    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int fCount = 0;
        int tCount = 0;
        int l = 0;
        int ans = 0;
        for (int i = 0; i < answerKey.length(); i ++) {
            if (answerKey.charAt(i) == 'F') {
                fCount ++;
            } else {
                tCount ++;
            }

            while (l < answerKey.length() && (fCount > k && tCount > k)) {
                if (answerKey.charAt(l) == 'F') {
                    fCount --;
                } else {
                    tCount --;
                }
                l++;
            }

            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
