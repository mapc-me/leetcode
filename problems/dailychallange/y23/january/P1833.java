package dailychallange.y23.january;

import java.util.Arrays;

public class P1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int i = 0;

        while (i < costs.length) {
            if (coins < costs[i]) {
                return i;
            }
            coins -= costs[i];
            i++;
        }

        return i;

    }

}
