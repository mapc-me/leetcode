package dfs;

import leetcodestructures.TreeNode;

public class P1448 {
    int answer = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return answer;

    }

    public void dfs(TreeNode node, int maximum) {
        if (node.val >= maximum) {
            answer ++;
        }
        maximum = Math.max(maximum, node.val);

        if (node.left != null) {
            dfs(node.left, maximum);

        }
        if (node.right != null) {
            dfs(node.right, maximum);
        }
    }
}
