package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P721 {

    public static void main(String[] args) {
        String[][] arr = { { "David", "Avid0@m.co", "David0@m.co", "David1@m.co" }, { "David", "Gvid3@m.co", "David3@m.co", "David4@m.co" },
            { "David", "David4@m.co", "David5@m.co" }, { "David", "David2@m.co", "David3@m.co" },
            { "David", "David1@m.co", "David2@m.co" } };
        List<List<String>> list = new ArrayList<>();
        for (String[] a : arr) {
            list.add(Arrays.stream(a).toList());
        }
        System.out.println(accountsMerge(list));
    }

    public static class DSU {
        private int[] size;
        private int[] repres;

        public DSU(int n) {
            repres = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                repres[i] = i;
            }
        }

        public int find(int index) {
            if (index == repres[index]) {
                return index;
            }
            repres[index] = find(repres[index]);
            return repres[index];
        }

        public void union(int x, int y) {
            int xIndex = find(x);
            int yIndex = find(y);

            if (size[xIndex] >= size[yIndex]) {
                repres[yIndex] = xIndex;
                size[xIndex] += size[yIndex];
            } else {
                repres[xIndex] = yIndex;
                size[yIndex] += size[xIndex];
            }
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());

        Map<String, Integer> emailWithIndex = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (!emailWithIndex.containsKey(email)) {
                    emailWithIndex.put(email, i);
                } else {
                    dsu.union(emailWithIndex.get(email), i);
                }
            }
        }

        Map<Integer, List<String>> groupedEmails = new HashMap<>();
        emailWithIndex.forEach((email, index) -> {
            int realIndex = dsu.find(index);
            if (groupedEmails.containsKey(realIndex)) {
                groupedEmails.get(realIndex).add(email);
            } else {
                List<String> emails = new ArrayList<>();
                emails.add(email);
                groupedEmails.put(realIndex, emails);
            }
        });
        List<List<String>> result = new ArrayList<>();
        groupedEmails.forEach((index, value) -> {
            Collections.sort(value);
            value.add(0, accounts.get(index).get(0));
            result.add(value);
        });

        return result;
    }

}
