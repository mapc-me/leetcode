package codeforces.binarysearch.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CClosestToTheRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        for (int i = 0; i < k; i ++) {
            int number = scanner.nextInt();
            System.out.println(binarySearch(list, number) + 1);
        }
    }

    public static int binarySearch(List<Integer> list, int target) {
        int l = -1;
        int r = list.size();

        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }
}
