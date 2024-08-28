import java.util.*;

public class Main {
    static String defaultString;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        defaultString = "";
        for (int i = 0; i < n; i++)
            defaultString += ".";
        for (int i = 0; i < n; i++)
            path.add(new String(defaultString));

        process(n, res, path, 0);
        return res;
    }

    public static boolean isValid(List<String> path, int rowIndex, int colIndex, int n) {
        int rowCount = 0;
        int leftDiag = 0;
        int rightDiag = 0;
        int colCount = 0;

        for (int i = 0; i < n; i++) {
            rowCount = path.get(i).charAt(colIndex) == 'Q' ? rowCount + 1 : rowCount;
        }

        for (int i = 0; i < n; i++)
            colCount = path.get(rowIndex).charAt(i) == 'Q' ? colCount + 1 : colCount;

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0;) {
            leftDiag = path.get(i).charAt(j) == 'Q' ? leftDiag + 1 : leftDiag;
            i--;
            j--;
        }

        for (int i = rowIndex + 1, j = colIndex + 1; i < n && j < n;) {
            leftDiag = path.get(i).charAt(j) == 'Q' ? leftDiag + 1 : leftDiag;
            i++;
            j++;
        }

        for (int i = rowIndex + 1, j = colIndex - 1; i < n && j >= 0;) {
            rightDiag = path.get(i).charAt(j) == 'Q' ? rightDiag + 1 : rightDiag;
            i++;
            j--;
        }

        for (int i = rowIndex - 1, j = colIndex + 1; j < n && i >= 0;) {
            rightDiag = path.get(i).charAt(j) == 'Q' ? rightDiag + 1 : rightDiag;
            i--;
            j++;
        }
        boolean ans = rowCount < 2 && colCount < 2 && leftDiag < 1 && rightDiag < 1;
        return ans;
    }

    public static void process(int n, List<List<String>> res, List<String> path, int rowIndex) {
        if (n == rowIndex) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            char[] curr = defaultString.toCharArray();
            curr[i] = 'Q';
            path.set(rowIndex, String.valueOf(curr));
            if (isValid(path, rowIndex, i, n))
                process(n, res, path, rowIndex + 1);
            path.set(rowIndex, defaultString);
        }
    }

    public static void main(String[] args) {
        int N = 4;

        System.out.println(solveNQueens(N));
    }
}
