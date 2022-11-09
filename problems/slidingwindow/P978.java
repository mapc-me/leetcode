package slidingwindow;

public class P978 {

    public static void main(String[] args) {

//        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
//        System.out.println(maxTurbulenceSize(new int[]{4,8,12,9,10,7,8}));
//        System.out.println(maxTurbulenceSize(new int[]{1, 2, 1, 2, 1, 2}));
        System.out.println(maxTurbulenceSize(new int[]{9,9, 1}));
//        System.out.println(maxTurbulenceSize(new int[] { 4, 8, 12, 16 }));
    }

    public static int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int anchor = 0;
        int ans = 1;

        for (int i = 1; i < arr.length; i++) {

            int lastComp = Integer.compare(arr[i - 1], arr[i]);

            if (lastComp == 0) {
                anchor = i;
            } else if (i == arr.length - 1 || lastComp * Integer.compare(arr[i], arr[i + 1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;

    }
}