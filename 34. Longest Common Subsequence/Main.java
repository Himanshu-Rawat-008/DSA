public class Main {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i == 0 && j == 0)
                    dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : 0;
                else if (i == 0)
                    dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : dp[i][j - 1];
                else if (j == 0)
                    dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : dp[i - 1][j];
                else if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1]));

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int ans = longestCommonSubsequence(text1, text2);
        System.out.println(ans);
    }
}
