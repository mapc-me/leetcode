package binarysearch;

public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = findRow(matrix, target);
        return findInRow(matrix[targetRow], target);
    }

    public boolean findInRow(int[] row, int target) {
        int l = 0;
        int r = row.length;
        int mid;

        while (r > l) {
            mid = (r + l) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (row[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return false;
    }

    public int findRow(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length;
        int mid;

        while (r - l > 1) {
            mid = (l + r) / 2;
            if (matrix[mid][0] > target) {
                r = mid - 1;
            } else if (matrix[mid][0] <= target) {
                l = mid;
            }
        }

        int ans = l;
        if (r < matrix.length && matrix[r][0] <= target) {
            ans = r;
        }
        return ans;
    }
}
