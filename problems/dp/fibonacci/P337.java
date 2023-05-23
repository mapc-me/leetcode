package dp.fibonacci;

import leetcodestructures.TreeNode;

public class P337 {
    public int rob(TreeNode root) {
        Pair p = dfs(root);


        return p.prev1;

    }

    public Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        return new Pair(
            Math.max(left.prev2 + right.prev2 + root.val, left.prev1 + right.prev1),
            Math.max(left.prev1, left.prev2) + Math.max(right.prev1, right.prev2)
        );
    }

    static class Pair {
        int prev1;
        int prev2;

        public Pair(int prev1, int prev2) {
            this.prev1 = prev1;
            this.prev2 = prev2;
        }
    }
}
