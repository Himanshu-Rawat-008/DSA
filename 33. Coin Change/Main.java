import java.util.*;

public class Main {

    public static int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                int prevAmount = i - coins[j];
                if (prevAmount < 0)
                    continue;
                if (dp[prevAmount] == -1)
                    continue;

                minCoins = Math.min(dp[prevAmount] + 1, minCoins);
            }
            dp[i] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(nums, amount));
    }
}
