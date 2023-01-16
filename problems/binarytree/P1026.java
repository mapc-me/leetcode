package binarytree;

import leetcodestructures.TreeNode;

public class P1026 {
    private int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        find(root, root.val, root.val);
        return ans;
    }

    public void find(TreeNode node, int maxAncestor, int minAncestor) {
        if (node == null) {
            return;
        }

        ans = Math.max(ans, Math.max(Math.abs(maxAncestor - node.val), Math.abs(minAncestor - node.val)));

        maxAncestor = Math.max(maxAncestor, node.val);
        minAncestor = Math.min(minAncestor, node.val);

        find(node.left, maxAncestor, minAncestor);
        find(node.right, maxAncestor, minAncestor);
    }
}
