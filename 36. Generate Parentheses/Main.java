import java.util.*;

public class Main {

    static List<String> helper(int open, int close, String s, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(s);
            return res;
        }
        if (open > 0)
            helper(open - 1, close, s + "(", res);
        if (open < close)
            helper(open, close - 1, s + ")", res);
        return res;
    }

    public static List<String> generateParenthesis(int n) {
        return helper(n, n, "", new ArrayList<>());
    }

    public static void main(String[] args) {
        int N = 3;
        System.out.println(generateParenthesis(N));
    }
}
