package fastslowpointers;

public class P328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode last = head;
        int count = 1;

        while (last.next != null) {
            last = last.next;
            count ++;
        }

        ListNode oddNode = head.next;
        ListNode prev = head;

        for (int i = 0; i < count / 2; i++) {

            ListNode nextOdd = oddNode.next.next;
            prev.next = oddNode.next;


            last.next = oddNode;
            oddNode.next = null;


            last = last.next;
            oddNode = nextOdd;
            prev = prev.next;

        }


        return head;
    }
}
