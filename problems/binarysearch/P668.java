package binarysearch;

public class P668 {
    public int findKthNumber(int m, int n, int k) {
        if (m > n) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        k = Math.min(k, n * m);


        int l = 1;
        int r = m * n;

        int counter = 0;
        int mid = 0;
        int last = 0;


        while (l < r) {
            mid = (l + r) / 2;
            // System.out.println(l + " " + r + " " + mid);
            last = 0;
            counter = 0;

            for (int i = 1; i <= n; i ++) {
                counter += Math.min(mid / i, m);
            }

            // System.out.println(counter + " " + k);

            if (counter < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
