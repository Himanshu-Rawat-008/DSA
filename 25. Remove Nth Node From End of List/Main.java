public class Main {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;
        while (n > -1) {
            fast = fast.next;
            n = n - 1;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
