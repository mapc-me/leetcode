package slidingwindow;

public class P209 {

    public static void main(String[] args) {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int currentSum = 0;
        int answer = -1;

        while (l < nums.length) {
            while (currentSum < target && r < nums.length) {
                currentSum += nums[r];
                    r++;
            }
            if (currentSum < target) {
                break;
            }

            int currentLength = r - l;
            if (answer == -1) {
                answer = currentLength;
            } else {
                answer = Math.min(answer, currentLength);
            }
            currentSum -= nums[l];
            l++;
        }

        return answer == -1 ? 0 : answer;
    }
}
