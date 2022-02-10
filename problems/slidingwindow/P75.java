package slidingwindow;

public class P75 {
    public void sortColors(int[] nums) {
        int[] commonArr = new int[3];
        for (int currentColor : nums) {
            commonArr[currentColor] += 1;
        }
        int[] answer = new int[nums.length];

        int index = 0;
        for (int i = 0; i < commonArr.length; i ++) {
            int color = commonArr[i];
            for (int j = 0; j < color; j ++) {
                answer[index] = i;
                index ++;
            }
        }

    }
}
