package binarytree;

import java.util.ArrayList;
import java.util.List;

public class P872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeafs = new ArrayList<>();
        List<Integer> secondLeafs = new ArrayList<>();

        collectLeafs(root1, firstLeafs);
        collectLeafs(root2, secondLeafs);

        return firstLeafs.equals(secondLeafs);

    }

    public void collectLeafs(TreeNode node, List<Integer> leafValues) {
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
            return;
        }
        if (node.left != null) {
            collectLeafs(node.left, leafValues);
        }
        if (node.right != null) {
            collectLeafs(node.right, leafValues);
        }
    }
}
