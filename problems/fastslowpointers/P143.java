package fastslowpointers;

public class P143 {
    public void reorderList(P141.ListNode head) {
        P141.ListNode slow = head;
        P141.ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        fast = reverse(slow);
        slow = head;


        P141.ListNode fastNext, slowNext;

        while (fast != null) {

            slowNext = slow.next;
            fastNext = fast.next;


            slow.next = fast;
            if (fast.next != null) {
                fast.next = slowNext;
            }

            slow = slowNext;
            fast = fastNext;
        }
    }

    public P141.ListNode reverse(P141.ListNode head) {
        P141.ListNode prev = null;
        P141.ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
