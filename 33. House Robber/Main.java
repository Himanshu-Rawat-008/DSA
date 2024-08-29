public class Main {
    public static int rob(int[] nums) {

        int N = nums.length;

        if (N == 1)
            return nums[0];

        for (int i = 2; i < N; i++) {
            int first = nums[i - 2];
            int second = i - 3 > -1 ? nums[i - 3] : 0;

            nums[i] = Math.max(first, second) + nums[i];
        }

        return Math.max(nums[N - 1], nums[N - 2]);

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }
}
