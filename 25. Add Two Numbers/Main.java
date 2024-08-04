public class Main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode l = null;
        ListNode curr = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;

            if (l == null) {
                l = new ListNode(val);
                curr = l;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (l == null) {
                l = new ListNode(val);
                curr = l;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (l == null) {
                l = new ListNode(val);
                curr = l;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return l;
    }

    public static void main(String[] args) {

    }
}
