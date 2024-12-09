import java.util.*;

public class Main {
    public static boolean findIndex(int node, int target, int[] v, ArrayList<ArrayList<Integer>> adj) {
        if (v[node] == 1)
            return false;
        if (node == target)
            return true;
        v[node] = 1;

        ArrayList<Integer> curr = adj.get(node);
        for (int newNode : curr)
            if (findIndex(newNode, target, v, adj))
                return true;

        return false;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        // N will be same as number of nodes
        int N = edges.length;

        int visited[] = new int[N + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i : visited)
            adj.add(new ArrayList<>());

        for (int edge[] : edges) {
            int a = edge[0];
            int b = edge[1];
            visited = new int[N + 1];
            if (findIndex(a, b, visited, adj))
                return edge;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        int res[] = findRedundantConnection(edges);
        System.out.println(res[0] + " " + res[1]);
    }
}
