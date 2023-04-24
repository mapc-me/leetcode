package grind75.week1;

import leetcodestructures.Node;

import java.util.HashMap;
import java.util.Map;

public class Leetcode133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);
        traversal(node, newNode, new HashMap<>());

        return newNode;
    }

    public void traversal(Node original, Node target, Map<Node, Node> map) {
        map.put(original, target);

        for (Node node : original.neighbors) {
            if (!map.containsKey(node)) {
                Node newNode = new Node(node.val);
                target.neighbors.add(newNode);
                traversal(node, newNode, map);
            } else {
                target.neighbors.add(map.get(node));
            }
        }

    }
}
