import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq;

    public static int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones)
            pq.add(stone);

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a - b);
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }
}
