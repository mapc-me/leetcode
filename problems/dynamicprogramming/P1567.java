package dynamicprogramming;

public class P1567 {

    public static void main(String[] args) {
        int[] arr = { 0, 1, -2, -3, -4 };
        System.out.println(getMaxLen(arr));
    }

    public static int getMaxLen(int[] nums) {
        final int n = nums.length;

        int answer = 0;
        int suffix = 0;
        int prefix = 0;
        int start = 0;
        int zeroCounter = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (zeroCounter % 2 != 0) {
                    answer = Math.max(answer, Math.max(i - start - prefix - 1, i - start - suffix - 1));
                } else {
                    answer = Math.max(answer, i - start);
                }

                zeroCounter = 0;
                start = i + 1;
                prefix = 0;
                suffix = 0;
                continue;
            }
            if (nums[i] > 0) {
                suffix++;
            } else {
                zeroCounter++;
                if (zeroCounter == 1) {
                    prefix = suffix;
                }
                suffix = 0;
            }
        }

        if (zeroCounter % 2 != 0) {
            answer = Math.max(answer, Math.max(n - start - prefix - 1, n - start - suffix - 1));
        } else {
            answer = Math.max(answer, n - start);
        }

        return answer;
    }
}
