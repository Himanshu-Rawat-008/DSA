public class Main {
    public static Node copyRandomList(Node head) {
        if (head == null)
            return head;

        HashMap<Node, Integer> m = new HashMap<>();
        HashMap<Integer, Node> m1 = new HashMap<>();

        Node newHead = null;

        Node newCurr = null;
        Node curr = head;
        int i = 0;

        while (curr != null) {
            if (newHead == null) {
                newHead = new Node(curr.val);
                newCurr = newHead;
                m1.put(i, newCurr);
            } else {
                newCurr.next = new Node(curr.val);
                newCurr = newCurr.next;
                m1.put(i, newCurr);
            }
            m.put(curr, i);
            i++;
            curr = curr.next;
        }

        curr = head;
        newCurr = newHead;
        while (curr != null) {
            Node oldRandom = curr.random;
            if (oldRandom != null) {
                Integer oldRandomIndex = m.get(oldRandom);
                Node newRandom = m1.get(oldRandomIndex);
                newCurr.random = newRandom;
            }
            newCurr = newCurr.next;
            curr = curr.next;
        }

        return newHead;
    }

}
