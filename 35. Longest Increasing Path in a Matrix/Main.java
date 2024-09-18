import java.util.*;

public class Main {
    static int dp[][];
    static int m;
    static int n;

    public static int helper(int[][] matrix, int rowIndex, int colIndex) {
        if (rowIndex == m || rowIndex < 0)
            return 0;
        if (colIndex == n || colIndex < 0)
            return 0;

        if (dp[rowIndex][colIndex] != -1)
            return dp[rowIndex][colIndex];
        int curr = matrix[rowIndex][colIndex];
        int left = colIndex > 0 && curr < matrix[rowIndex][colIndex - 1] ? helper(matrix, rowIndex, colIndex - 1) : 0;
        int right = colIndex + 1 < n && curr < matrix[rowIndex][colIndex + 1] ? helper(matrix, rowIndex, colIndex + 1)
                : 0;
        int up = rowIndex > 0 && curr < matrix[rowIndex - 1][colIndex] ? helper(matrix, rowIndex - 1, colIndex) : 0;
        int down = rowIndex + 1 < m && curr < matrix[rowIndex + 1][colIndex] ? helper(matrix, rowIndex + 1, colIndex)
                : 0;

        dp[rowIndex][colIndex] = Math.max(Math.max(left, right), Math.max(up, down)) + 1;
        return dp[rowIndex][colIndex];
    }

    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int ans = 0;
        for (int row[] : dp)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dp[i][j] == -1) {
                    dp[i][j] = helper(matrix, i, j);
                    ans = Math.max(dp[i][j], ans);
                } else {
                    ans = Math.max(dp[i][j], ans);
                }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(longestIncreasingPath(matrix));
    }
}
