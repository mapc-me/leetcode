package slidingwindow;

public class P1031 {

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,0,9,5,0,3,8};

        System.out.println(maxSumTwoNoOverlap(arr, 4, 3));
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] sumForFirst = new int[nums.length];
        int[] sumForSecond = new int[nums.length];
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < nums.length; i++) {
            firstSum += nums[i];
            secondSum += nums[i];

            if (i + 1 >= firstLen) {
                sumForFirst[i] = firstSum;
                firstSum -= nums[i - firstLen + 1];
            } else {
                sumForFirst[i] = 0;
            }

            if (i + 1 >= secondLen) {
                sumForSecond[i] = secondSum;
                secondSum -= nums[i - secondLen + 1];
            } else {
                sumForSecond[i] = 0;
            }

        }


        return Math.max(
                max(sumForFirst, sumForSecond, firstLen, secondLen),
                max(sumForSecond, sumForFirst, secondLen, firstLen)
        );

    }

    public static int max(int[] sumFirst, int[] sumSecond, int firstLen, int secondLen) {
        int max = 0;

        for (int i = firstLen - 1; i < sumFirst.length - secondLen; i++) {
            for (int j = i + secondLen; j < sumSecond.length; j++) {
                max = Math.max(max, sumFirst[i] + sumSecond[j]);
            }
        }

        return max;

    }
}
