import java.util.*;

class Pair {
    public int index;
    public int number;

    Pair(int index, int number) {
        this.index = index;
        this.number = number;
    }
}

public class Main {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int max[] = new int[N - k + 1];
        PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>((Pair p1, Pair p2) -> p1.number > p2.number ? -1 : 1);
        for (int i = 0; i < k; i++)
            pQueue.add(new Pair(i, nums[i]));
        max[0] = pQueue.peek().number;
        for (int i = k, j = 1; i < N; i++, j++) {
            while (!pQueue.isEmpty() && pQueue.peek().index < i - k + 1)
                pQueue.poll();
            pQueue.add(new Pair(i, nums[i]));
            max[i - k + 1] = pQueue.peek().number;
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, -1 },
                { 1, 3, -1, -3, 5, 3, 6, 7 },
                { 10, 9, 8, 7, 6 },
        };
        int[][] k = { { 1 }, { 3 }, { 2 } };
        int m = nums.length;

        for (int i = 0; i < m; i++) {
            int[] res = maxSlidingWindow(nums[i], k[i][0]);
            for (int j = 0; j < res.length; j++)
                System.out.print(res[j] + " ");
            System.out.println();
        }
    }
}
