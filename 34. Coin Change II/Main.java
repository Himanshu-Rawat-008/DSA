public class Main {
    static int dp[][];

    public static int change(int amount, int[] coins) {
        int N = coins.length;
        dp = new int[N + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }

        return dp[N][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int coins[] = { 1, 2, 5 };
        System.out.println(change(amount, coins));
    }
}
