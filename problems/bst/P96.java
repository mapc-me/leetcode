package bst;

public class P96 {
    public int numTrees(int n) {
        int[] functionResult = new int[n + 1];
        functionResult[0] = 1;
        functionResult[1] = 1;

        int currentResult = 0;
        for (int i = 2; i <= n; i++) {
            currentResult = 0;
            for (int j = 1; j <= i; j++) {
                currentResult += functionResult[j - 1] * functionResult[i - j];
            }
            functionResult[i] = currentResult;
        }

        return functionResult[n];
    }
}
