import java.util.*;

class Pair {
    public int x;
    public int y;
    public int d;

    int distance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    Pair(int x, int y, int[][] points) {
        this.x = x;
        this.y = y;
        this.d = distance(points[x], points[y]);
    }
}

public class Main {

    static int minCostConnectPoints(int[][] points) {
        int N = points.length;
        boolean visited[] = new boolean[N];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        pq.add(new Pair(0, 0, points));
        int res = 0;
        int rem = N;

        while (rem > 0) {
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int d = p.d;

            if (visited[y])
                continue;

            visited[y] = true;
            rem--;
            res += d;

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    pq.add(new Pair(y, i, points));
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(minCostConnectPoints(points));
    }
}