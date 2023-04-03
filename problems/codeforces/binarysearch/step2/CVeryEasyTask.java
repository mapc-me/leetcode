package codeforces.binarysearch.step2;

import java.util.Scanner;

public class CVeryEasyTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        long l = 0;
        long r = (long) n * (Math.min(x, y)) + 1;

        while (l < r - 1) {
            long mid = (l + r) / 2;
            if (isGood(x, y, n, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.println(r);
    }

    public static boolean isGood(int x, int y, int n, long candidate) {
        int min = Math.min(x, y);
        if (candidate < min) {
            return false;
        }
        candidate -= min;
        return candidate / x + candidate / y >= n - 1;
    }
}
