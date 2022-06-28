package fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class P202 {

    public boolean isHappySlowFastPointers(int n) {

        int fast = n;
        int slow = n;

        while (true) {
            slow = operation(slow);
            fast = operation(operation(fast));

            if (fast == 1 || fast == slow) {
                System.out.println(fast + ' ' + slow);
                break;
            }
        }

        return fast == 1;
    }

    public boolean isHappyHashTableSolution(int n) {
        Set<Integer> was = new HashSet<>();

        while (!was.contains(n) && n != 1) {
            was.add(n);
            n = operation(n);
        }

        return n == 1;
    }

    public int operation(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
