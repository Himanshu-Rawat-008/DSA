public class Main {
    public static int maxProduct(int[] nums) {

        int N = nums.length;
        int dp1[] = new int[N];
        int dp2[] = new int[N];

        int max = Integer.MIN_VALUE;

        dp1[0] = nums[0];
        max = Math.max(dp1[0], max);
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = dp1[i - 1] != 0 ? nums[i] * dp1[i - 1] : nums[i];
            max = Math.max(dp1[i], max);
        }

        dp2[N - 1] = nums[N - 1];
        max = Math.max(dp2[N - 1], max);
        for (int i = N - 2; i > -1; i--) {
            dp2[i] = dp2[i + 1] != 0 ? nums[i] * dp2[i + 1] : nums[i];
            max = Math.max(dp2[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }
}
