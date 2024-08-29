public class Main {
    public static int rob(int[] nums) {
        int N = nums.length;
        if (N == 1)
            return nums[0];
        int dp1[] = new int[N];
        int max1 = Integer.MIN_VALUE;
        int dp2[] = new int[N];
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            dp1[i] = dp2[i] = nums[i];
            max1 = Math.max(max1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
        }

        for (int i = 2; i < N - 1; i++) {
            int first = i - 3 < 0 ? 0 : dp1[i - 3];
            int second = dp1[i - 2];
            dp1[i] = Math.max(first, second) + nums[i];
            max1 = Math.max(max1, dp1[i]);
        }

        for (int i = 3; i < N; i++) {
            int first = i - 3 < 1 ? 0 : dp2[i - 3];
            int second = dp2[i - 2];
            dp2[i] = Math.max(first, second) + nums[i];
            max2 = Math.max(max2, dp2[i]);
        }

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 2 };
        System.out.println(rob(nums));
    }
}
