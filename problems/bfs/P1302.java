package bfs;

import leetcodestructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P1302 {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ans = 0;
            int size = queue.size();

            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();

                ans += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return ans;

    }
}
