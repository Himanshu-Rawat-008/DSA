public class Main {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++)
            for (int j = i; j < nums.length; j++)
                if (nums[j] + nums[j - i] == target) {
                    return new int[] { j - i, j };
                }
        return null;
    }

    public static void main(String[] args) {
        int a[] = { 2, 7, 11, 15 };
        int n = a.length;
        int res[] = twoSum(a, 9);
        System.out.println(res[0] + " " + res[1]);
    }
}
