package binarytree;

import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P897 {
    List<Integer> values = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode();
        dfs(root);

        TreeNode next = ans;
        for (int i = 0; i < values.size() - 1; i++) {
            next.val = values.get(i);
            next.right = new TreeNode();
            next = next.right;
        }

        next.val = values.get(values.size() - 1);

        return ans;
    }

    void dfs(TreeNode actual) {
        if (actual == null) {
            return;
        }

        if (actual.left != null) {
            dfs(actual.left);
        }

        values.add(actual.val);

        if (actual.right != null) {
            dfs(actual.right);
        }
    }
}
