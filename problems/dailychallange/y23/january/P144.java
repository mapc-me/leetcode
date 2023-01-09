package dailychallange.y23.january;


import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P144 {
    List<Integer> answer = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return answer;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
