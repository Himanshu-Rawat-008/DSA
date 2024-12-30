import java.util.*;

public class Main {
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        // sort priority queue based on least time taken
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[] { 0, 0, grid[0][0] });
        grid[0][0] = -1;

        while (!pq.isEmpty()) {
            // get rowIndex, colIndex, and least time taken to reach here
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            // least time taken to reach here
            int max = curr[2];

            for (int x = 0; x < 4; x++) {
                int i = r + dx[x];
                int j = c + dy[x];

                if (i == -1 || j == -1 || i == n || j == n || grid[i][j] == -1)
                    continue;
                int val = grid[i][j];
                // max because will take atleast this value to reach here
                int maxi = Math.max(max, val);
                // mark visited
                grid[i][j] = -1;

                // if already at end that means its the answer because of priority queue
                if (i == n - 1 && j == n - 1)
                    return maxi;
                pq.add(new int[] { i, j, maxi });
            }
        }

        // will never reach here
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 2 }, { 1, 3 } };
        System.out.println(swimInWater(grid));
    }
}
