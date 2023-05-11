package kwaymerge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : arr) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }


        int[] a = new int[counter.size()];
        int index = 0;


        for (Integer num : counter.keySet()) {
            a[index++] = counter.get(num);
        }

        Arrays.sort(a);

        int cnt = 0;

        for (int i = 0; i < counter.size() && k > 0; i++) {
            if (a[i] <= k) {
                cnt ++;
            }
            k -= a[i];
        }

        return counter.size() - cnt;
    }
}
