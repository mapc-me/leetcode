package binarytree;

import leetcodestructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P1339 {

    private List<Long> nodeSum = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long sum = sumOfTree(root, 0);

        System.out.println("SUM " + sum);

        long max = 0;
        for (Long value : nodeSum) {
            max = Math.max(max, (sum - value) * value);
        }

        return (int) (max % 1_000_000_007);
    }

    public long sumOfTree(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }

        long left = sumOfTree(root.left, sum);
        long right = sumOfTree(root.right, sum);

        nodeSum.add(left + right + root.val);
        return left + right + root.val;
    }

}
