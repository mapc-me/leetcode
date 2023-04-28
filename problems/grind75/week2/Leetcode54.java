package grind75.week2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean left = true;
        boolean bottom = true;

        int n = matrix.length;
        int m = matrix[0].length;
        int nStart = 0;
        int mStart = 0;
        int nFinish = n - 1;
        int mFinish = m - 1;

        List<Integer> result = new ArrayList<>();

        while (nStart <= nFinish && mStart <= mFinish) {

            for (int i = mStart; i <= mFinish; i++) {
                result.add(matrix[nStart][i]);
            }

            for (int i = nStart + 1; i <= nFinish; i++) {
                result.add(matrix[i][mFinish]);
            }

            if (nStart < nFinish) {
                for (int i = mFinish - 1; i >= mStart; i--) {
                    result.add(matrix[nFinish][i]);
                }
            }

            if (mStart < mFinish) {
                for (int i = nFinish - 1; i > nStart; i--) {
                    result.add(matrix[i][mStart]);
                }
            }

            nStart++;
            mStart++;
            nFinish--;
            mFinish--;
        }

        return result;

    }
}
