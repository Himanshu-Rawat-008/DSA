public class Main {
    public static int search(int[] nums, int target) {
        int N = nums.length;
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (e + s) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
    }
}
