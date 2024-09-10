public class Main {
    static int maxP(int[] prices, int N) {
        if (N == 0 || N == 1)
            return 0;

        int[] dp = new int[N];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (i < 2)
                maxDiff = Math.max(maxDiff, -prices[i]);

            if (i == 0)
                dp[i] = 0;
            else if (i == 1)
                dp[i] = Math.max(prices[i] - prices[0], 0);
            else {
                dp[i] = Math.max(dp[i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 2] - prices[i]);
            }
        }
        return dp[N - 1];
    }

    public static int maxProfit(int[] prices) {
        int N = prices.length;
        return maxP(prices, N);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(nums));
    }
}
