package codeforces.binarysearch.step1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFastSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);

        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int leftIndex;
            int rightIndex;
            if (l > r) {
                leftIndex = findClosestToTheLeft(list, r);
                rightIndex = findClosestToTheRight(list, l);
            } else {
                leftIndex = findClosestToTheLeft(list, l);
                rightIndex = findClosestToTheRight(list, r);
            }
            System.out.println(rightIndex - leftIndex + 1);
        }

    }

    public static int findClosestToTheLeft(List<Integer> list, int target) {
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

    public static int findClosestToTheRight(List<Integer> list, int target) {
        int l = -1;
        int r = list.size();

        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}

