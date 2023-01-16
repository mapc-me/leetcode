package bst;

import leetcodestructures.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class P173 {

    class BSTIterator {
        Set<TreeNode> used = new HashSet<>();
        TreeNode root;

        public BSTIterator(TreeNode root) {
            this.root = root;
        }

        public int next() {
            TreeNode found = find(root);
            if (found == null) {
                return 0;
            }
            used.add(found);
            System.out.println("finish " + found.val );
            return found.val;
        }

        public TreeNode find(TreeNode node) {
            System.out.println(node.val);
            if (used.contains(node) && node.right != null) {
                return find(node.right);
            }
            if (used.contains(node)) {
                return null;
            }
            if (node.left != null) {
                TreeNode left = find(node.left);
                if (left != null) {
                    return left;
                }
            }
            return node;
        }

        public boolean hasNext() {
            return find(root) != null;
        }
    }
}
