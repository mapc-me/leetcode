package contest;

public class P6104 {

    public static void main(String[] args) {
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    public static int countAsterisks(String s) {
        int sum = 0;

        String[] split = s.split("\\|");
        for (int i  = 0; i < split.length; i ++) {
            if (i % 2 == 1) {
                continue;
            }
            String currentS = split[i];
            for (int j = 0; j < currentS.length(); j ++) {
                if (currentS.charAt(j) == '*') {
                    sum ++;
                }
            }
        }

        return sum;


    }

}
