package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class P424 {

    public static void main(String[] args) {

        String s = "DEEE";
        int k = 0;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int answer = 0;
        int currentAnswer = 0;

        for (int i = 0; i < s.length(); ) {
            char letter = s.charAt(i);
            currentAnswer++;
            addToMap(map, letter);
            i++;

            if (k - getCurrentReplacement(map) < 0) {
                answer = checkAnswer(currentAnswer - 1, answer);
                removeFromMap(map, s.charAt(left));
                left++;
                currentAnswer--;
            }
        }

        answer = checkAnswer(currentAnswer, answer);
        return answer;
    }

    public static int getCurrentReplacement(Map<Character, Integer> map) {
        int max = 0;
        int count = 0;
        for (Character letter : map.keySet()) {
            int currentCounter = map.get(letter);
            count += currentCounter;
            if (currentCounter > max) {
                max = currentCounter;
            }
        }
        return count - max;
    }

    public static int checkAnswer(int currentAnswer, int answer) {
        return Math.max(currentAnswer, answer);
    }

    public static void addToMap(Map<Character, Integer> map, Character key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static void removeFromMap(Map<Character, Integer> map, Character key) {
        if (map.get(key) > 1) {
            map.put(key, map.get(key) - 1);
        } else {
            map.remove(key);
        }
    }
}
