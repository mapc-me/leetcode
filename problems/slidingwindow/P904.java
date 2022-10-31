package slidingwindow;

/**
 * Good example o sliding window
 */
public class P904 {
    public int totalFruit(int[] fruits) {
        int[] counter = new int[fruits.length];

        int r = 0;
        int ans = 0;
        int currentSize = 0;

        for (int i = 0; i < fruits.length; i++) {
            while (currentSize <= 2 && r < fruits.length) {
                if (counter[fruits[r]] == 0 && currentSize == 2) {
                    break;
                }
                if (counter[fruits[r]] == 0) {
                    currentSize ++;
                }
                counter[fruits[r]] ++;
                r ++;
            }

            ans = Math.max(ans, r - i);
            counter[fruits[i]] -- ;
            if (counter[fruits[i]] == 0) {
                currentSize --;
            }
        }

        return ans;

    }
}
