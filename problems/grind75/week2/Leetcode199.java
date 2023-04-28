package grind75.week2;

import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode199 {
    List<Integer> answer = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightOrientedTraversal(root, 0);
        return answer;

    }

    public void rightOrientedTraversal(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= answer.size()) {
            answer.add(node.val);
        }


        level ++;
        rightOrientedTraversal(node.right, level);
        rightOrientedTraversal(node.left, level);
    }
}
