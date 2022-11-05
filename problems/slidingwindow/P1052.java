package slidingwindow;

public class P1052 {

    public static void main(String[] args) {
        int[] customers = { 10, 1, 7 };
        int[] grumpy = { 0, 0, 0 };

        int minutes = 2;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int satisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        int ans = 0;

        int current = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                satisfied -= customers[i];
            }
            current += customers[i];

            if (i < minutes - 1) {
                continue;
            }

            ans = Math.max(ans, satisfied + current);
            current -= customers[i - minutes + 1];
            if (grumpy[i - minutes + 1] == 0) {
                satisfied += customers[i - minutes + 1];
            }
        }

        return ans;

    }
}
