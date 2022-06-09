package sorting.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class P986 {

    public static void main(String[] args) {
//        int[][] first = {{0,2},{5,10},{13,23},{24,25}};
//        int[][] second = {{1,5},{8,12},{15,24},{25,26}};
        int[][] first = {{1,7}};
        int[][] second = {{0,2},{3,4},{5,6}};

        intervalIntersection(first, second);
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstPointer = 0;
        int secondPointer = 0;
        List<int[]> ans = new ArrayList<>();

        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            if (firstList[firstPointer][0] >= secondList[secondPointer][0]
                    && firstList[firstPointer][0] <= secondList[secondPointer][1] ||
                    secondList[secondPointer][0] >= firstList[firstPointer][0]
                            && secondList[secondPointer][0] <= firstList[firstPointer][1]) {
                int[] interval = new int[2];
                interval[0] = Math.max(firstList[firstPointer][0], secondList[secondPointer][0]);
                interval[1] = Math.min(firstList[firstPointer][1], secondList[secondPointer][1]);
                ans.add(interval);
            }
            if (firstList[firstPointer][1] > secondList[secondPointer][1]) {
                secondPointer ++;
            } else {
                firstPointer ++;
            }
        }

        int[][] intAns = new int[ans.size()][2];
        int i = 0;
        for (int[] arr : ans) {
            intAns[i][0] = arr[0];
            intAns[i][1] = arr[1];
            i ++;
        }

        return intAns;
    }
}
