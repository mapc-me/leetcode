package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcodestructures.Node;

public class P429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();

        if (root == null) {
            return answer;
        }

        answer.add(List.of(root.val));

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Node node = queue.poll();

                for (Node child : node.children) {
                    list.add(child.val);
                    queue.add(child);
                }
            }
            if (!list.isEmpty()) {
                answer.add(list);
            }
        }

        return answer;
    }
}
