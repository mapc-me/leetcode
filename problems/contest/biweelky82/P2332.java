package contest.biweelky82;

import java.util.Arrays;

public class P2332 {
    public static void main(String[] args) {
//        int[] buses = {18,8,3,12,9,2,7,13,20,5 };
//        int[] passengers = { 13,10,8,4,12,14,18,19,5,2,30,34 };
        int[] buses = {4 };
        int[] passengers = { 3,4 };
        System.out.println(latestTimeCatchTheBus(buses, passengers, 1));
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(passengers);
        Arrays.sort(buses);

        int bus = 0;
        int pass = 0;
        int currentCapacity = 0;
        int ans = 0;
        int candidate = -1;
        while (bus < buses.length) {

            while (pass < passengers.length && passengers[pass] <= buses[bus] && currentCapacity < capacity) {
                if (candidate == -1 || pass > 0 && passengers[pass - 1] != passengers[pass] - 1) {
                    candidate = passengers[pass];
                }
                pass++;
                currentCapacity++;
            }
            if (currentCapacity < capacity && (pass > 0 && buses[bus] != passengers[pass - 1]) || pass == 0) {
                ans = Math.max(ans, buses[bus]);
            } else {
                ans = Math.max(ans, candidate - 1);
            }
            bus++;
            currentCapacity = 0;

        }

        return ans;
    }
}
