package bst;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P95 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        generateTrees(4);
    }


    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] function = new List[n + 1];
        for (int i = 0; i < function.length; i++) {
            function[i] = new ArrayList<>();
        }
        return generateSubtrees(1, n, function);
    }

    private static List<TreeNode> generateSubtrees(int s, int e, List<TreeNode>[] calculated) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1, calculated);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e, calculated);


            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}