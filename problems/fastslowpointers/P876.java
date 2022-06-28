package fastslowpointers;

public class P876 {
    public P141.ListNode middleNode(P141.ListNode head) {
        P141.ListNode slow = head;
        P141.ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;


    }
}
