public class Main {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int N = height.length;
        int res = 0;

        int[] max_left_to_right = new int[N];
        int[] max_right_to_left = new int[N];

        max_left_to_right[0] = height[0];
        max_right_to_left[N - 1] = height[N - 1];

        for (int i = 1; i < N; i++)
            max_left_to_right[i] = Math.max(max_left_to_right[i - 1], height[i]);

        for (int i = N - 2; i > -1; i--)
            max_right_to_left[i] = Math.max(max_right_to_left[i + 1], height[i]);

        for (int i = 0; i < N; i++) {
            res += Math.min(max_right_to_left[i], max_left_to_right[i]) - height[i];
        }

        return res;
    }
}
