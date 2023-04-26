package grind75.week1;

public class Leetcode155 {
    class MinStack {

        class Node {
            int min;
            int value;
            Node next;

            public Node(int min, int value, Node next) {
                this.min = min;
                this.value = value;
                this.next = next;
            }

        }

        private Node head;

        public MinStack() {
        }

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val, null);
            } else {
                head = new Node(Math.min(head.min, val), val, head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;

        }
    }
}
