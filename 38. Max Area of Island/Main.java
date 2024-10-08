public class Main {
    static int m;
    static int n;
    static boolean[][] v;

    static int getArea(int[][] grid, int rowIndex, int colIndex) {
        if (rowIndex == m || colIndex == n || rowIndex == -1 || colIndex == -1)
            return 0;
        if (v[rowIndex][colIndex])
            return 0;
        if (grid[rowIndex][colIndex] == 0)
            return 0;

        v[rowIndex][colIndex] = true;

        int a = getArea(grid, rowIndex + 1, colIndex);
        int b = getArea(grid, rowIndex - 1, colIndex);
        int c = getArea(grid, rowIndex, colIndex + 1);
        int d = getArea(grid, rowIndex, colIndex - 1);

        return a + b + c + d + 1;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        v = new boolean[m][n];

        int maxArea = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && v[i][j] == false) {
                    int area = getArea(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
