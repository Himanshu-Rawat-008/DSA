public class Main {
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int N = nums.length;

        nums = productExceptSelf(nums);

        for (int i = 0; i < N; i++)
            System.out.print(nums[i] + " ");
    }
}
