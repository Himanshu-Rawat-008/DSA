import java.util.*;

public class Main {
    public static int numDistinct(String s, String t) {
        int N = s.length();
        int M = t.length();

        int dp[][] = new int[M + 1][N + 1];

        dp[0][0] = 1;
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct(s, t));
    }
}
