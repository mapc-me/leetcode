package dynamicprogramming;

/**
 * PREMIUM
 * <p>
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on… Find the minimum cost to paint all houses.
 */
public class P256 {

    public int paint(int[][] houses) {
        int red = houses[0][0];
        int blue = houses[0][1];
        int green = houses[0][2];
        for (int i = 1; i < houses.length; i++) {
            int[] house = houses[i];
            red = Math.min(red + house[1], red + house[2]);
            blue = Math.min(blue + house[0], blue + house[2]);
            green = Math.min(green + house[1], green + house[2]);
        }

        return Math.min(red, Math.min(blue, green));
    }

}
