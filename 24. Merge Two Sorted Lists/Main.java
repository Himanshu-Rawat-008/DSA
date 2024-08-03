public class Main {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = null;
        ListNode prev = null;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (list == null) {
                    list = list1;
                    prev = list;
                } else {
                    prev.next = list1;
                    prev = prev.next;
                }
                list1 = list1.next;
            } else {
                if (list == null) {
                    list = list2;
                    prev = list;
                } else {
                    prev.next = list2;
                    prev = prev.next;
                }
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            if (list == null) {
                list = list1;
                prev = list;
            } else {
                prev.next = list1;
                prev = prev.next;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            if (list == null) {
                list = list2;
                prev = list;
            } else {
                prev.next = list2;
                prev = prev.next;
            }
            list2 = list2.next;
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
