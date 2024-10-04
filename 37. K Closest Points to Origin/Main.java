import java.util.*;

class Pair {
    public int[] point;
    public int value;

    Pair(int[] point) {
        this.point = point;
        this.value = (point[0] * point[0]) + (point[1] * point[1]);
    }
}

public class Main {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.value - b.value);

        for (int[] point : points)
            pq.add(new Pair(point));

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++)
            res[i] = pq.poll().point;

        return res;
    }

    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        int ans[][] = kClosest(points, k);

        for (int i = 0; i < ans.length; i++)
            System.out.println(ans[i][0] + " " + ans[i][1]);
    }
}
