import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[][] v;

    public static void helper(int[][] grid, int i, int j, int min) {
        if (i < 0 || j < 0 || i == m || j == n)
            return;
        if (v[i][j] <= min)
            return;

        if (grid[i][j] == 0) {
            v[i][j] = 0;
            return;
        }

        v[i][j] = Math.min(v[i][j], min);

        helper(grid, i, j - 1, min + 1);
        helper(grid, i, j + 1, min + 1);
        helper(grid, i - 1, j, min + 1);
        helper(grid, i + 1, j, min + 1);
    }

    public static int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        v = new int[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(v[i], Integer.MAX_VALUE);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 2)
                    helper(grid, i, j, 0);

        int res = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && v[i][j] == Integer.MAX_VALUE)
                    return -1;
                else if (grid[i][j] == 1)
                    res = Math.max(v[i][j], res);

        return res;
    }

    public static void main(String[] args) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        System.out.println(orangesRotting(grid));
    }
}
