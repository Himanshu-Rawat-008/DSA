public class Main {
    public static int numDecodings(String s) {
        int N = s.length();
        int dp[] = new int[N + 1];

        if (s.charAt(0) == '0')
            return 0;

        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            if (i - 2 > -1) {
                int dig = Integer.parseInt(s.substring(i - 2, i));
                if (10 <= dig && dig <= 26)
                    dp[i] += dp[i - 2];
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
    }
}
