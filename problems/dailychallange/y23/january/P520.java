package dailychallange.y23.january;

public class P520 {
    public boolean detectCapitalUse(String word) {
        boolean firstIsBig = Character.isUpperCase(word.charAt(0));
        boolean wasSmall = !firstIsBig;
        boolean wasBig = false;

        for(int i = 1; i < word.length(); i ++) {
            if (Character.isLowerCase(word.charAt(i)) && wasBig) {
                return false;
            }
            if (Character.isUpperCase(word.charAt(i)) && wasSmall) {
                return false;
            }
            if (Character.isLowerCase(word.charAt(i))) {
                wasSmall = true;
            } else {
                wasBig = true;
            }
        }

        return true;

    }
}
