public class Main {
    public static String longestPalindrome(String s) {
        int N = s.length();
        String res = s.substring(0, 1);
        int dp[][] = new int[N][N];

        for (int i = 0; i < N; i++)
            dp[i][i] = 1;

        for (int i = 1; i < N; i++) {
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i) ? 2 : 0;
            if (dp[i - 1][i] > res.length())
                res = s.substring(i - 1, i + 1);
        }

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (s.charAt(j) == s.charAt(i + j) && dp[j + 1][i + j - 1] > 0) {
                    dp[j][i + j] = dp[j + 1][i + j - 1] + 2;
                    if (dp[j][i + j] > res.length()) {
                        res = s.substring(j, i + j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
