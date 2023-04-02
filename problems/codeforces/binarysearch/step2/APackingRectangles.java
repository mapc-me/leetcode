package codeforces.binarysearch.step2;

import java.util.Scanner;

public class APackingRectangles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int n = scanner.nextInt();

        long l = -1;
        long r = findR(h, w, n);

        while (l < r - 1) {
            long mid = (r + l) / 2;
            if (isGood(mid, h, w, n)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.println(r);
    }

    public static long findR(int h, int w, int n) {
        long r = 1;
        while(!isGood(r, h, w, n)) {
            r *= 2;
        }
        return r;
    }

    public static boolean isGood(long x, int h, int w, int n) {
        return  (x / h) * (x / w) >= n;
    }
}