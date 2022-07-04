package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P127 {

    public static void main(String[] args) {
//        String start = "hit";
//        String end = "hid";
//        List<String> arr = Stream.of("hid").collect(Collectors.toList());
//        String start = "hit";
//        String end = "cog";
//        List<String> arr = Stream.of("hot","dot","dog","lot","log","cog").collect(Collectors.toList());
        String start = "hit";
        String end = "hot";
        List<String> arr = Stream.of("hot").collect(Collectors.toList());
        System.out.println(ladderLengthSecondSolution(start, end, arr.stream().collect(Collectors.toSet())));

    }

    public static int ladderLengthSecondSolution(String beginWord, String endWord, Set<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> endSet = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        endSet.add(endWord);
        beginSet.add(beginWord);
        visited.add(beginWord);

        int distance = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> toAdd = new HashSet<>();

            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            for (String reached : beginSet) {
                String next;
                char[] chars = reached.toCharArray();
                for (int i = 0; i < reached.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = chars[i];
                        chars[i] = ch;
                        next = String.valueOf(chars);

                        if (endSet.contains(next)) {
                            return distance + 1;
                        }

                        if (!visited.contains(next) && wordList.contains(next)) {
                            toAdd.add(next);
                            wordList.remove(next);
                            visited.add(next);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = toAdd;
            distance++;
        }

        return 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        int diff = 0;

        wordList.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String anotherWord = wordList.get(j);

                diff = 0;
                for (int k = 0; k < word.length(); k++) {
                    if (word.charAt(k) != anotherWord.charAt(k)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    if (!graph.containsKey(word)) {
                        List<String> arr = new ArrayList<>();
                        graph.put(word, arr);
                    }
                    if (!graph.containsKey(anotherWord)) {
                        List<String> arr = new ArrayList<>();
                        graph.put(anotherWord, arr);
                    }
                    graph.get(word).add(anotherWord);
                    graph.get(anotherWord).add(word);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        distance.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            if (visited.contains(currentVertex)) {
                continue;
            }
            visited.add(currentVertex);
            if (!graph.containsKey(currentVertex)) {
                continue;
            }
            for (String next : graph.get(currentVertex)) {
                if (!distance.containsKey(next) || distance.get(currentVertex) + 1 < distance.get(next)) {
                    distance.put(next, distance.get(currentVertex) + 1);
                    queue.add(next);
                }
            }
        }
        return distance.getOrDefault(endWord, 0);

    }

}
