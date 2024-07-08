
import java.util.*;

public class Main {

    public static boolean isValidCell(char[][] board, int r, int c) {

        int len = 9;

        int qRow = r / 3;
        int startRow = qRow * 3;
        int endRow = (qRow + 1) * 3;

        int qCol = c / 3;
        int startCol = qCol * 3;
        int endCol = (qCol + 1) * 3;

        ArrayList<Character> arr = new ArrayList<>();

        for (int i = startRow; i < endRow; i++)
            for (int j = startCol; j < endCol; j++)
                if (arr.contains(board[i][j]))
                    return false;
                else if (board[i][j] != '.')
                    arr.add(board[i][j]);

        // entire column
        arr = new ArrayList<>();
        for (int i = 0; i < len; i++)
            if (arr.contains(board[i][c]))
                return false;
            else if (board[i][c] != '.')
                arr.add(board[i][c]);

        // entire row
        arr = new ArrayList<>();
        for (int j = 0; j < len; j++)
            if (arr.contains(board[r][j]))
                return false;
            else if (board[r][j] != '.')
                arr.add(board[r][j]);

        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int len = 9;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (board[i][j] != '.') {
                    if (!isValidCell(board, i, j))
                        return false;
                }
        return true;
    }

    public static void main(String[] args) {

        char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

        System.out.println(isValidSudoku(board));

        char[][] board1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(isValidSudoku(board1));
    }
}