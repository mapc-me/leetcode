package contest.biweelky82;

import leetcodestructures.TreeNode;

public class P2331 {

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