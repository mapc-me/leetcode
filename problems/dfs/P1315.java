package dfs;

import leetcodestructures.TreeNode;

public class P1315 {

    int answer = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false, false);

        return answer;

    }

    public void dfs(TreeNode root, boolean parentEven, boolean grandParentEven) {

        if (grandParentEven) {
            answer += root.val;
        }

        if (root.left != null) {
            dfs(root.left, root.val % 2 == 0, parentEven);
        }
        if (root.right != null) {
            dfs(root.right, root.val % 2 == 0, parentEven);
        }
    }
}
