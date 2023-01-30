package topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P2115 {

    public static void main(String[] args) {
        String[] recipes = { "bread", "sandwich", "burger" };
        List<List<String>> ingridients = List.of(
            List.of("yeast", "flour"),
            List.of("bread", "meat"),
            List.of("sandwich", "meat", "bread")
        );
        String[] supplies = { "yeast", "flour", "meat" };

//        String[] recipes =
//            { "xevvq", "izcad", "p", "we", "bxgnm", "vpio", "i", "hjvu", "igi", "anp", "tokfq", "z", "kwdmb", "g", "qb", "q", "b", "hthy" };
//        List<List<String>> ingridients = List.of(
//            List.of("wbjr"),
//            List.of("otr", "fzr", "g"),
//            List.of("fzr", "wi", "otr", "xgp", "wbjr", "igi", "b"),
//            List.of("fzr", "xgp", "wi", "otr", "tokfq", "izcad", "igi", "xevvq", "i", "anp"),
//            List.of("wi", "xgp", "wbjr"),
//            List.of("wbjr", "bxgnm", "i", "b", "hjvu", "izcad", "igi", "z", "g"),
//            List.of("xgp", "otr", "wbjr"),
//            List.of("wbjr", "otr"),
//            List.of("wbjr", "otr", "fzr", "wi", "xgp", "hjvu", "tokfq", "z", "kwdmb"),
//            List.of("xgp", "wi", "wbjr", "bxgnm", "izcad", "p", "xevvq"), List.of("bxgnm"),
//            List.of("wi", "fzr", "otr", "wbjr"),
//            List.of("wbjr", "wi", "fzr", "xgp", "otr", "g", "b", "p"),
//            List.of("otr", "fzr", "xgp", "wbjr"),
//            List.of("xgp", "wbjr", "q", "vpio", "tokfq", "we"),
//            List.of("wbjr", "wi", "xgp", "we"), List.of("wbjr"), List.of("wi")
//        );
//        String[] supplies = { "wi", "otr", "wbjr", "fzr", "xgp" };
        System.out.println(topologicalSort(recipes, ingridients, supplies));
    }

    public static List<String> bfsApproach(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < recipes.length; i++) {
            queue.offer(i);
        }

        Set<String> seen = new HashSet<>(Arrays.asList(supplies));
        List<String> answer = new ArrayList<>();

        int prevSize = 0;
        while (seen.size() > prevSize) {
            prevSize = seen.size();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                int index = queue.poll();
                boolean allSeen = true;
                for (String ingredient : ingredients.get(index)) {
                    if (!seen.contains(ingredient)) {
                        allSeen = false;
                        break;
                    }
                }
                if (allSeen) {
                    seen.add(recipes[index]);
                    answer.add(recipes[index]);
                } else {
                    queue.add(index);
                }
            }
        }

        return answer;
    }

    public static List<String> topologicalSort(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> degree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {

            for (String ingredient : ingredients.get(i)) {
                if (!graph.containsKey(ingredient)) {
                    graph.put(ingredient, new HashSet<>());
                }
                graph.get(ingredient).add(recipes[i]);
                degree.put(recipes[i], degree.getOrDefault(recipes[i], 0) + 1);
            }
        }

        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));
        List<String> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String leave = queue.poll();
                if (!suppliesSet.contains(leave) || !graph.containsKey(leave)) {
                    continue;
                }

                for (String node : graph.get(leave)) {
                    degree.put(node, degree.get(node) - 1);
                    if (degree.get(node) == 0) {
                        queue.offer(node);
                        suppliesSet.add(node);
                        answer.add(node);
                    }
                }
            }
        }

        return answer;
    }
}

