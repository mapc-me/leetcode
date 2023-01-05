package dailychallange.y23.january;

import java.util.Arrays;

public class P452 {

    public static void main(String[] args) {

        int[][] arr = {{-2147483646,-2147483645},{2147483646,2147483647}};

        findMinArrowShots(arr);
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int ans = 1;
        int y = points[0][1];
        for (int i = 1; i < points.length; i ++) {
            if (points[i][0] > y) {
                ans ++;
                y = points[i][1];
            } else {
                y = Math.min(y, points[i][1]);
            }
        }

        return ans;

    }
}
