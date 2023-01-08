package dailychallange.y23.january;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class P149 {

    public static void main(String[] args) {
//        int[][] arr = {{1,1},{2,2},{3,3}};
//        int[][] arr = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int[][] arr = { { 9, -25 }, { -4, 1 }, { -1, 5 }, { -7, 7 } };

        System.out.println(maxPoints(arr));
    }

    static class Coefficients {
        double k;
        double b;

        public Coefficients(double k, double b) {
            this.k = k;
            this.b = b;
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coefficients that = (Coefficients) o;
            return k == that.k && b == that.b;
        }

        @Override public int hashCode() {
            return Objects.hash(k, b);
        }
    }

    public static int maxPoints(int[][] points) {
        // equiption of straight line
        //(x - a1)/(a2 - a1) = (y - b1)/(b2 - b1);

        final int n = points.length;

        int answer = 1;

        for (int i = 0; i < n; i++) {
            Map<Coefficients, Integer> canonical = new HashMap<>();
            Map<Integer, Integer> parallelX = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0]) {
                    parallelX.put(points[i][0], parallelX.getOrDefault(points[i][0], 0) + 1);
                    answer = Math.max(parallelX.get(points[i][0]) + 1, answer);

                } else {
                    double k = calculateKCoefficient(points[i][0], points[j][0], points[i][1], points[j][1]);
                    Coefficients coeff = new Coefficients(
                        k,
                        calculateBCoefficient(k, points[i][0], points[i][1], points[j][1])
                    );

                    canonical.put(coeff, canonical.getOrDefault(coeff, 0) + 1);
                    answer = Math.max(canonical.get(coeff) + 1, answer);
                }
            }
        }

        return answer;

    }

    public static double calculateKCoefficient(int x1, int x2, int y1, int y2) {
        if (y1 == y2) {
            return 0;
        }
        return -((x2 - x1) / (double) (y2 - y1));
    }

    public static double calculateBCoefficient(double k, int x1, int y1, int y2) {
        if (y1 == y2) {
            return y1;
        }
        return k * y1 - x1;
    }
}
