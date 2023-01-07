package dailychallange.y23.january;

public class P134 {

    public static void main(String[] args) {
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};

//        int[] gas = {5,5,1,3,4};
//        int[] cost = {8,1,7,1,1};
//
        int[] gas = { 3, 1, 1 };
        int[] cost = { 1, 2, 2 };

        System.out.println(canCompleteCircuit(gas, cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        final int n = gas.length;

        int l = 0;
        int r = 0;
        int left = 0;

        while (l < n) {
            while (r < n && gas[r] + left >= cost[r]) {
                left += gas[r] - cost[r];
                r++;
            }
            r++;
            if (r > n) {
                break;
            }
            l = r;
            left = 0;
        }

        for (int i = 0; i < l; i++) {
            if (gas[i] + left < cost[i]) {
                return -1;
            }
            left -= cost[i] - gas[i];
        }

        return l;
    }
}

