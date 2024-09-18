public class Main {

    public static int minDistance(String word1, String word2) {

        int M = word2.length();
        int N = word1.length();
        int dp[][] = new int[M + 1][N + 1];

        for (int i = 0; i <= M; i++)
            dp[i][0] = i;

        for (int j = 0; j <= N; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
