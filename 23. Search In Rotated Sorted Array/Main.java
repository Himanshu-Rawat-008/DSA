public class Main {
    public static void main(String[] args) {
        int[][][] nums = {
                { { 8, 1, 2, 3, 4, 5, 6, 7 }, { 6 } },
                { { 5, 1, 2, 3, 4 }, { 1 } },
                { { 5, 1, 3 }, { 3 } },
                { { 4, 5, 6, 7, 8, 1, 2, 3 }, { 8 } } };

        for (int i = 0; i < nums.length; i++) {
            System.out.println(search(nums[i][0], nums[i][1][0]));
        }
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
