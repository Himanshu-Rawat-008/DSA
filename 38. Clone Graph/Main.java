public class Main {
    private HashMap<Node, Node> map = new HashMap<>();

    private Node helper(Node node) {
        if (node == null)
            return node;
        if (map.containsKey(node))
            return map.get(node);

        // create main node with empty neighbors
        Node newNode = new Node(node.val, new ArrayList<Node>());

        // retreive neighbors
        List<Node> oldNeighbors = node.neighbors;
        map.put(node, newNode);

        for (int i = 0; i < oldNeighbors.size(); i++) {
            Node oldNeighbor = oldNeighbors.get(i);
            if (map.containsKey(oldNeighbor))
                newNode.neighbors.add(map.get(oldNeighbor));
            else {
                Node newNeighbor = cloneGraph(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        return helper(node);
    }

    public static void main(String[] args) {

    }
}
