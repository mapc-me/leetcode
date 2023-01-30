package util;

public class ChangeArrayBrackets {

    public static void main(String[] args) {
        String array = "[[\"yeast\",\"flour\"],[\"bread\",\"meat\"],[\"sandwich\",\"meat\",\"bread\"]]";

        System.out.println(array.replace("[", "{").replace("]", "}"));
    }
}
