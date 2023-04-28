package grind75.week2;

import leetcodestructures.TreeNode;

public class Leetcode236 {
    TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = new TreeNode();
        find(root, p, q);

        return lca;

    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean match = root.val == p.val || root.val == q.val;

        boolean existsInLeft = find(root.left, p, q);
        boolean existsInRight = find(root.right, p, q);

        if (existsInLeft && existsInRight || existsInLeft && match || existsInRight && match) {
            lca = root;
        }

        return match || existsInLeft || existsInRight;
    }
}
