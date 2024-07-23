public class Main {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int col = 0;
        int row = 0;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] <= target && target <= matrix[i][n - 1])
                row = i;

        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = (e + s) / 2;

            if (matrix[row][mid] == target || matrix[row][s] == target || matrix[row][e] == target)
                return true;
            else if (matrix[row][mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
