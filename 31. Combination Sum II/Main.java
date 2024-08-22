import java.util.*;;

public class Main {
    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        process(candidates, 0, new ArrayList<Integer>(), target);

        return res;
    }

    public static void process(int[] nums, int index, List<Integer> path, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        int prev = -1;

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] == 0) {
                // System.out.println(path+"-"+nums[i]+"-"+index);
            }
            if (prev == nums[i]) {
                // System.out.println(path+"-"+nums[i]+"-"+index);
                continue;
            }
            path.add(nums[i]);
            process(nums, i + 1, path, target - nums[i]);
            path.remove(path.size() - 1);
            prev = nums[i];
        }
    }

    public static void main(String[] args) {
        int nums[] = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        System.out.println(combinationSum2(nums, target));
    }
}
