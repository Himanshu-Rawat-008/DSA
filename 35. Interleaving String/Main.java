import java.util.*;

public class Main {
    static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3)
            return false;
        if (n3 == 0)
            return true;
        boolean dp[][] = new boolean[n1 + 1][n2 + 1];
        for (boolean[] row : dp)
            Arrays.fill(row, false);

        dp[0][0] = true;

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else {
                    char ch1 = i > 0 ? s1.charAt(i - 1) : ' ';
                    char ch2 = j > 0 ? s2.charAt(j - 1) : ' ';
                    char ch3 = s3.charAt(i + j - 1);
                    if (ch2 == ch3)
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    if (ch1 == ch3)
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}