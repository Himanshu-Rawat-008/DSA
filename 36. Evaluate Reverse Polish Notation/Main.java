import java.util.*;

public class Main {

    static String expressions[] = { "*", "+", "/", "-" };

    static boolean isExpression(String s) {
        for (String expression : expressions)
            if (s.equals(expression))
                return true;
        return false;
    }

    static int calculate(int a, int b, String s) {
        if (expressions[0].equals(s)) {
            return a * b;
        }
        if (expressions[1].equals(s)) {
            return a + b;
        }
        if (expressions[2].equals(s)) {
            return a / b;
        }
        if (expressions[3].equals(s)) {
            return a - b;
        }
        return 0;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (isExpression(s)) {
                int a = st.pop();
                int b = st.pop();
                int ans = calculate(b, a, s);
                st.push(ans);
            } else
                st.push(Integer.parseInt(s));
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String[] s = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(s));
    }
}
