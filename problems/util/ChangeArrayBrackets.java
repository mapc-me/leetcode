package util;

public class ChangeArrayBrackets {

    public static void main(String[] args) {
        String array = "[[0,1],[0,2],[1,3],[0,4]]";

        System.out.println(array.replace("[", "{").replace("]", "}"));
    }
}
