import java.util.*;

public class Main {

    static char O = 'O';
    static char X = 'X';
    static char S = 'S';
    static int m;
    static int n;

    public static char[][] helper(char[][] board, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0)
            return board;
        if (board[i][j] == S || board[i][j] == X)
            return board;

        board[i][j] = S;

        board = helper(board, i - 1, j);
        board = helper(board, i + 1, j);
        board = helper(board, i, j - 1);
        board = helper(board, i, j + 1);
        return board;
    }

    public static void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == O)
                    board = helper(board, i, j);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == O)
                    board[i][j] = X;
                else if (board[i][j] == S)
                    board[i][j] = O;
    }

    public static void main(String[] args) {
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        solve(board);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}