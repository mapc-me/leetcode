package contest.biweelky82;

import java.util.Arrays;

public class P2331 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean evaluateTree(TreeNode root) {
            return evaluate(root);
        }

        public boolean evaluate(TreeNode root) {
            if (root.left != null) {
                boolean leftValue = false;
                boolean rightValue = true;
                leftValue = evaluateTree(root.left);
                rightValue = evaluateTree(root.right);
                if (root.val == 2) {
                    return leftValue || rightValue;
                } else {
                    return leftValue && rightValue;
                }
            } else {
                return root.val == 1;
            }
        }
    }

}