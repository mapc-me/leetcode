package grind75.week1;

import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        traversal(root, answer, 0);
        return answer;
    }

    public void traversal(TreeNode root, List<List<Integer>> answer, int level) {
        if (answer.size() <= level) {
            answer.add(new ArrayList<>());
        }
        answer.get(level).add(root.val);

        if (root.left != null) {
            traversal(root.left, answer, level + 1);
        }
        if (root.right != null) {
            traversal(root.right, answer, level + 1);
        }
    }
}
