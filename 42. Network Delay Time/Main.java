import java.util.*;

class Pair {
    public int target;
    public int weight;

    Pair(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Main {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // n is total number of nodes;
        // k is starting point
        // times store source, traget and weight respectively

        // get all the targets for a single source in array
        List<List<Pair>> srcToTarget = new ArrayList<>();

        // assign all srcToTarget with empty list
        for (int i = 0; i <= n; i++)
            srcToTarget.add(new ArrayList<>());

        // add all targets to src with weight
        // 0 = source, 1 = target, 2 = weight
        for (int i = 0; i < times.length; i++)
            srcToTarget.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));

        // create array for storing minimum time taken to reach that point
        int[] timeTaken = new int[n + 1];

        // assign values with max value
        Arrays.fill(timeTaken, Integer.MAX_VALUE);

        // time taken by starting point k is 0
        timeTaken[k] = 0;

        // create queue to store latest sources
        Queue<Integer> sourceQ = new LinkedList<>();
        // add starting source
        sourceQ.add(k);

        // iterate over all sources to fill timeTaken to reach with minimum time
        while (!sourceQ.isEmpty()) {
            int source = sourceQ.poll();

            // get all target for parentNode
            List<Pair> targets = srcToTarget.get(source);

            // iterate over all targets
            for (Pair p : targets) {
                int weight = p.weight;
                int target = p.target;

                // compare current weight i.e timeTaken[source] + weight
                // with stored weight i.e timeTaken[target]

                if (timeTaken[source] + weight < timeTaken[target]) {
                    timeTaken[target] = timeTaken[source] + weight;
                    sourceQ.add(target);
                }

            }
        }

        // to find maximum time taken
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++)
            res = Math.max(res, timeTaken[i]);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}
