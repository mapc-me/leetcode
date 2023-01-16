package dynamicprogramming;

import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        List<TreeNode> init = new ArrayList<>();
        init.add(new TreeNode(0, null, null));
        dp.put(1, init);

        for (int i = 3; i <= n; i += 2) {
            List<TreeNode> list = new ArrayList<>();
            for (int j = 1; j < i; j += 2) {
                for (TreeNode right : dp.get(j)) {
                    for (TreeNode left : dp.get(i - j - 1)) {
                        TreeNode tree = new TreeNode(0);
                        tree.right = right;
                        tree.left = left;
                        list.add(tree);
                    }
                }
            }
            dp.put(i, list);
        }

        return dp.get(n);
    }
}
