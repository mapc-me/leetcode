package codeforces.binarysearch.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BRopes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        double l = 0;
        double r = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            list.add(element);
            r = Math.max(r, element);
        }
        r++;

        for (int i = 0; i < 100; i++) {
            double mid = (r + l) / 2;
            if (isGood(list, k, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        System.out.println(l);
    }

    public static boolean isGood(List<Integer> list, int k, double x) {
        long sum = 0;
        for (Integer rope : list) {
            sum += rope / x;
        }

        return sum >= k;
    }
}
