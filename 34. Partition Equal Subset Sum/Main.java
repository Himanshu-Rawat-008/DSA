public class Main {

    public static boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean dp[][] = new boolean[N + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[N][target];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums));
    }
}
