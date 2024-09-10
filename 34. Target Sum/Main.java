import java.util.*;;

public class Main {
    static HashMap<ArrayList<Integer>, Integer> map;

    public static int helper(int[] nums, int t, int index) {
        if (index == nums.length && t == 0)
            return 1;
        if (index == nums.length)
            return 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(t);
        arr.add(index);
        if (map.containsKey(arr))
            return map.get(arr);
        int c = helper(nums, t - nums[index], index + 1) + helper(nums, t + nums[index], index + 1);
        map.put(arr, c);
        return map.get(arr);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        int dp[][] = new int[N + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
            }
        }

        return dp[N][target];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
