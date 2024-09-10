import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    static int M;

    public static boolean isEqual(String s1, String s2) {
        return s1.equals(s2);
    }

    public static void helper(String s, List<String> wordDict, int startIndex) {
        if (startIndex == N) {
            dp[N] = 1;
            return;
        }

        if (dp[startIndex] != -1)
            return;
        dp[startIndex] = 1;

        String s1 = s.substring(startIndex, N);

        for (int i = 0; i < M; i++) {
            String currWord = wordDict.get(i);
            int n1 = currWord.length();
            if (n1 <= s1.length() && isEqual(s1.substring(0, n1), currWord)) {
                helper(s, wordDict, startIndex + n1);
            }
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        N = s.length();
        dp = new int[N + 1];
        M = wordDict.size();
        Arrays.fill(dp, -1);
        helper(s, wordDict, 0);
        return dp[N] == 1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }
}
