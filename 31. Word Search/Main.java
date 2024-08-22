public class Main {
    static int row;
    static int col;
    static int N;

    public static boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;

        N = word.length();
        boolean v[][] = new boolean[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (process(board, word, v, i, j, 0))
                    return true;
        return false;
    }

    public static boolean process(char[][] board, String word, boolean[][] v, int rowIndex, int colIndex, int index) {
        if (N == index)
            return true;
        if (rowIndex >= row || rowIndex < 0)
            return false;
        if (colIndex >= col || colIndex < 0)
            return false;
        if (v[rowIndex][colIndex])
            return false;

        v[rowIndex][colIndex] = true;
        if (word.charAt(index) == board[rowIndex][colIndex]) {
            // up
            if (process(board, word, v, rowIndex - 1, colIndex, index + 1))
                return true;
            // down
            if (process(board, word, v, rowIndex + 1, colIndex, index + 1))
                return true;
            // left
            if (process(board, word, v, rowIndex, colIndex - 1, index + 1))
                return true;
            // right
            if (process(board, word, v, rowIndex, colIndex + 1, index + 1))
                return true;
        }
        v[rowIndex][colIndex] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}
