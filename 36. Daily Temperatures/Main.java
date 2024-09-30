import java.util.*;

public class Main {
    static class Pair {
        public static int val;
        public static int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int[] dailyTemperatures(int[] t) {

        Stack<Pair> st = new Stack<>();
        int N = t.length;

        for (int i = N - 1; i > -1; i--) {
            if (i == N - 1) {
                st.push(new Pair(t[i], i));
                t[i] = 0;
            } else {
                while (!st.isEmpty() && t[i] >= st.peek().val)
                    st.pop();
                Pair curr = new Pair(t[i], i);
                t[i] = st.isEmpty() ? 0 : st.peek().index - i;
                st.push(curr);
            }
        }

        return t;
    }

    public static void main(String[] args) {
        int[] t = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(dailyTemperatures(t));
    }
}
