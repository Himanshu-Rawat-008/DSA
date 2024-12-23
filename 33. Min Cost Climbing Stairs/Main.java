public class Main {
    public static int minCostClimbingStairs(int[] cost) {
        int N = cost.length;

        int dp[] = new int[N + 1];
        dp[N - 1] = cost[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int N[] = { 10, 15, 20 };

        System.out.println(minCostClimbingStairs(N));
    }
}
