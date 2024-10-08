public class Main {

    static int m;
    static int n;
    static boolean[][] v;

    static void markVisited(char[][] grid, int rowIndex, int colIndex) {
        if (rowIndex == m || colIndex == n || rowIndex == -1 || colIndex == -1)
            return;
        if (v[rowIndex][colIndex])
            return;
        if (grid[rowIndex][colIndex] == '0')
            return;

        v[rowIndex][colIndex] = true;

        markVisited(grid, rowIndex + 1, colIndex);
        markVisited(grid, rowIndex - 1, colIndex);
        markVisited(grid, rowIndex, colIndex + 1);
        markVisited(grid, rowIndex, colIndex - 1);
    }

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        v = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && v[i][j] == false) {
                    count++;
                    markVisited(grid, i, j);
                }
            }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(numIslands(grid));
    }
}
