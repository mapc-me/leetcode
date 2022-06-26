package fastslowpointers;

public class P141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast == null || !fast.equals(slow)) {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }

        return true;

    }
}
