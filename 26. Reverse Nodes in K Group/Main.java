public class Main {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 0)
            return head;

        int count = 1;

        ListNode start = head;
        ListNode end = head;

        while (count < k) {
            end = end.next;
            if (end == null)
                return head;
            count++;
        }
        ListNode endNext = end.next;
        end.next = null;
        ListNode currHead = reverse(start);
        start.next = reverseKGroup(endNext, k);
        return currHead;
    }

    public static void main(String[] args) {

    }
}
