public class P1004 {
    public int longestOnes(int[] nums, int k) {
        int answer = 0;
        int currentAnswer = 0;
        int l = 0;
        boolean kIsNull = k == 0;
        for (int r = 0 ; r < nums.length;) {
            if (nums[r] == 1) {
                currentAnswer += 1;
                r ++;
                continue;
            }

            if (kIsNull) {
                if (currentAnswer > answer) {
                    answer = currentAnswer;
                }
                currentAnswer = 0;
                r ++;
                continue;
            }

            if (k == 0) {
                if (currentAnswer > answer) {
                    answer = currentAnswer;
                }
                if (nums[l] == 0) {
                    k += 1;
                }
                l ++;
                currentAnswer --;
            }

            if (nums[r] == 0 && k > 0) {
                k --;
                currentAnswer += 1;
                r ++;
            }
        }
        if (currentAnswer > answer) {
            answer = currentAnswer;
        }
        return answer;
    }
}
