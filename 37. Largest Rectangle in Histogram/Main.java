import java.util.*;

public class Main {
    static int[] prevSmallerElement(int[] h, int N) {
        int[] prev = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i])
                st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return prev;
    }

    static int[] nextSmallerElement(int[] h, int N) {
        int[] next = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = N - 1; i > -1; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i])
                st.pop();
            next[i] = st.isEmpty() ? N : st.peek();
            st.push(i);
        }

        return next;
    }

    public static int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] prev = prevSmallerElement(heights, N);
        int[] next = nextSmallerElement(heights, N);

        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            int curr = (next[i] - prev[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, curr);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}
