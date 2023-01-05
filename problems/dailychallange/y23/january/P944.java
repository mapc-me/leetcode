package dailychallange.y23.january;

public class P944 {
    public int minDeletionSize(String[] strs) {
        final int n = strs.length;
        final int length = strs[0].length();
        int ans = 0;

        for (int j = 0; j < length; j ++) {
            for (int i = 1; i < n; i ++) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    ans ++;
                    break;
                }
            }
        }

        return ans;

    }
}
