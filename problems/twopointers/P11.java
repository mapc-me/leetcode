package twopointers;

public class P11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) {
                r --;
            } else {
                l ++;
            }
        }
        return ans;
    }
}
