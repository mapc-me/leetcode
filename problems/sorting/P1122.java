package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P1122 {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

//        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        System.out.println(Arrays.toString(fasterRelativeSortArray(arr1, arr2)));
    }

    // O(N^2)
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> crossing = new HashSet<>();
        List<Integer> disjointValue = new ArrayList<>();
        for (Integer primary : arr2) {
            for (Integer secondary : arr1) {
                if (secondary.equals(primary)) {
                    crossing.add(secondary);
                    result.add(secondary);
                }
            }
        }
        for (Integer value : arr1) {
            if (!crossing.contains(value)) {
                disjointValue.add(value);
            }
        }

        Collections.sort(disjointValue);
        result.addAll(disjointValue);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    // O(N) with hash map
    public static int[] fasterRelativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> arr2Numbers = new LinkedHashSet<>();
        Map<Integer, Integer> crossNumbersCounterMap = new HashMap<>();
        List<Integer> disjointList = new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for (Integer number : arr2) {
            arr2Numbers.add(number);
        }

        for (Integer number : arr1) {

            if (arr2Numbers.contains(number)) {
                if (crossNumbersCounterMap.containsKey(number)) {
                    crossNumbersCounterMap.put(number, crossNumbersCounterMap.get(number) + 1);
                } else {
                    crossNumbersCounterMap.put(number, 1);
                }
            } else {
                disjointList.add(number);

            }
        }

        arr2Numbers.forEach(key -> {
            Integer count = crossNumbersCounterMap.get(key);
            for (int i = 0; i < count; i ++) {
                result.add(key);
            }
        });
        Collections.sort(disjointList);
        result.addAll(disjointList);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
