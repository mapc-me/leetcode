package binarytree;

import leetcodestructures.TreeNode;

public class P124 {

    int max = -1000;

    public int maxPathSum(TreeNode root) {
        int res = bfs(root);
        return max;
    }

    public int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, bfs(node.left));
        int right = Math.max(0, bfs(node.right));

        max = Math.max(max, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

}
