import java.util.*;

class Pair {
    public int src;
    public int price;

    Pair(int src, int price) {
        this.src = src;
        this.price = price;
    }
}

public class Main {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> all_prices = new ArrayList<>();
        for (int i = 0; i < n; i++)
            all_prices.add(new ArrayList<>());

        for (int[] f : flights)
            all_prices.get(f[0]).add(new int[] { f[1], f[2] });

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(src, 0);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        while (k > -1 && !q.isEmpty()) {
            Queue<Pair> q1 = new LinkedList<>();

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int curr_src = p.src;
                if (curr_src == dst)
                    continue;
                int curr_price = p.price;

                for (int[] f : all_prices.get(curr_src)) {
                    int new_src = f[0];
                    int new_price = curr_price + f[1];
                    if (new_price < map.getOrDefault(new_src, Integer.MAX_VALUE)) {
                        map.put(new_src, new_price);
                        q1.add(new Pair(new_src, new_price));
                    }
                }
            }
            q = q1;
            k--;
        }

        return map.getOrDefault(dst, -1);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
