package sorting;

import java.util.ArrayList;
import java.util.List;

public class P1859 {
    public static void main(String[] args) {
        String s = "Myself1";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        List<String> result = new ArrayList<>();
        String[] words = s.split(" ");
        String[] wordIndexArray = new String[10];

        for (String word : words) {
            int index = Integer.parseInt(word.substring(word.length() - 1));
            wordIndexArray[index] = word;
        }

        for (String word : wordIndexArray) {
            if (word != null) {
                result.add(word.substring(0, word.length() - 1));
            }
        }

        return String.join(" ", result);

    }
}
