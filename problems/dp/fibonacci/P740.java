package dp.fibonacci;

public class P740 {
    final int N = 10001;

    public int deleteAndEarn(int[] nums) {
        int[] counter = new int[N];

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            counter[num]++;
        }

        int minus1 = counter[1];
        int minus2 = 0;

        for (int i = 2; i <= max; i++) {
            int tmp = Math.max(counter[i] * i + minus2, minus1);
            minus2 = minus1;
            minus1 = tmp;
        }

        return minus1;
    }
}
