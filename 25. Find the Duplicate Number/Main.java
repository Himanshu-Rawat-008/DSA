public class Main {
    public static int findDuplicate(int[] nums) {

        int index = 0;
        int N = nums.length;
        while (index < N) {
            int curr = nums[index];
            int currIndex = nums[nums[index] - 1];
            if (currIndex == nums[index])
                index++;
            else {
                nums[index] = currIndex;
                nums[curr - 1] = curr;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i + 1 != nums[i])
                return nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
    }
}
