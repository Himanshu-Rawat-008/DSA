public class Main {
    public static int[][] longestPalindrome(String s, int N) {
        int dp[][] = new int[N][N];

        for (int i = 0; i < N; i++)
            dp[i][i] = 1;

        for (int i = 1; i < N; i++)
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i) ? 2 : 0;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (s.charAt(j) == s.charAt(i + j) && dp[j + 1][i + j - 1] > 0) {
                    dp[j][i + j] = dp[j + 1][i + j - 1] + 2;
                }
            }
        }

        return dp;
    }

    public static int countSubstrings(String s) {
        int N = s.length();
        int res[][] = longestPalindrome(s, N);
        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                ans = res[i][j] > 0 ? ans + 1 : ans;
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
