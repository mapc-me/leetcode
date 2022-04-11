package twopointers;

import java.util.ArrayList;
import java.util.List;

public class P19 {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> indexedNodes = new ArrayList<>();

            while (head.next != null) {
                indexedNodes.add(head);
                head = head.next;
            }
            indexedNodes.add(head);

            if (indexedNodes.size() == n) {
                if (indexedNodes.size() == 1) {
                    return null;
                }
                return indexedNodes.get(1);
            }

            indexedNodes.get(indexedNodes.size() - n - 1).next = n == 1
                    ? null
                    : indexedNodes.get(indexedNodes.size() - n + 1);

            return indexedNodes.get(0);

        }
    }
}
