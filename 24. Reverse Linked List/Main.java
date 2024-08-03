class ListNode {
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

public class Main {

    public static ListNode looping(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = looping(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode recursing(ListNode head) {
        if (head == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        ListNode head = null;
        ListNode prev = null;
        for (int i : nums) {
            if (head == null) {
                head = new ListNode(i);
                prev = head;
            } else {
                ListNode temp = new ListNode(i);
                prev.next = temp;
                prev = temp;
            }
        }
        prev.next = null;

        ListNode newHead = null;

        newHead = looping(head);
        prev = newHead;
        while (prev != null) {
            System.out.print(prev.val + " ");
            prev = prev.next;
        }
        System.out.println();

        prev = recursing(newHead);
        while (prev != null) {
            System.out.print(prev.val + " ");
            prev = prev.next;
        }
    }
}
