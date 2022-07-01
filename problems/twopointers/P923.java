package twopointers;

import java.util.Arrays;

public class P923 {

    public static void main(String[] args) {
//        int[] arr = {0,2,0,0};
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        System.out.println(threeSumMulti(arr, 8));

    }

    public static int threeSumMulti(int[] arr, int target) {
        long ans = 0;
        Arrays.sort(arr);

        int l, r;
        for (int i = 0;  i < arr.length - 2; i ++) {
            l = i + 1;
            r = arr.length - 1;
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] > target) {
                    r --;
                    continue;
                }
                if (arr[i] + arr[l] + arr[r] < target) {
                    l ++;
                    continue;
                }
                if (arr[i] + arr[l] + arr[r] == target) {
                    if (arr[l] == arr[r]) {
                        while (l < r) {
                            ans += r - l;
                            l++;
                        }
                        break;
                    }
                    int counterLeft = 1, counterRight = 1;
                    int newL = l;
                    int newR = r;
                    while (newL < r && arr[newL] == arr[newL + 1]) {
                        counterLeft ++;
                        newL ++;
                    }
                    while (l < newR && arr[newR] == arr[newR - 1]) {
                        counterRight++;
                        newR--;
                    }
                    l = newL + 1;
                    r = newR - 1;
                    ans += (long) counterLeft * counterRight;
                }
            }
        }

        return (int) (ans % (1000000000L + 7));

    }
}
