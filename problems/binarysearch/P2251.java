package binarysearch;

import java.util.Arrays;

public class P2251 {

    public static void main(String[] args) {
        int[][] arr = {{1,6},{3,7},{9,12},{4,13}};
        int[] pers = {14};

        System.out.println(Arrays.toString(fullBloomFlowers(arr, pers)));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length;
        int[] right = new int[n];
        int[] left = new int[n];

        int index = 0;
        for (int[] arr : flowers) {
            right[index] = arr[1];
            left[index] = arr[0];
            index++;
        }

        Arrays.sort(right);
        Arrays.sort(left);

        int[] result = new int[persons.length];

        int mid;
        for (int i = 0; i < persons.length; i ++) {
            int person = persons[i];
            int l = 0, r = n;

            while (r > l) {
                mid = (r + l) / 2;
                if (left[mid] <= person) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            int countForLeftBorder = l;

            l = 0;
            r = n;

            while (r > l) {
                mid = (r + l) / 2;
                if (right[mid] < person) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            int countForRightBorder = l;

            result[i] = countForLeftBorder - countForRightBorder;
        }

        return result;
    }
}
