package fastslowpointers;

public class P234 {
    public boolean isPalindrome(P141.ListNode head) {
        P141.ListNode slow = head;
        P141.ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null && fast.next == null) {
            slow = slow.next;
        }

        P141.ListNode newMiddle = reverse(slow);


        while(newMiddle != null) {
            if (head.val != newMiddle.val) {
                return false;
            }
            head = head.next;
            newMiddle = newMiddle.next;
        }

        return true;
    }

    public P141.ListNode reverse(P141.ListNode head) {
        P141.ListNode prev = null;
        P141.ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
