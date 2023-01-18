package bfs;

import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();

        queue.add(root);

        boolean oddLevel = true;
        while(!queue.isEmpty()) {;
            int size = queue.size();



            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    values.add(node.left.val);
                    values.add(node.right.val);
                }
            }

            if (oddLevel) {
                size = queue.size();
                int i = 0;
                for (TreeNode q : queue) {
                    q.val = values.get(size - i - 1);
                    i++;
                }
            }

            oddLevel = !oddLevel;
            values.clear();
        }

        return root;
    }
}
