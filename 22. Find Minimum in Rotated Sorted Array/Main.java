public class Main {

    public static int findMin(int[] nums) {

        int N = nums.length;
        int res = nums[0];
        for (int i = 1; i < N; i++) {
            if (nums[i] < nums[i - 1]) {
                res = nums[i];
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums));
    }
}
