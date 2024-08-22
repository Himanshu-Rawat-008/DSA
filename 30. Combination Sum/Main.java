import java.util.*;

public class Main {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        process(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    static void add(List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
    }

    public static void process(int[] nums, int start, int target, List<Integer> path, List<List<Integer>> res) {
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            if (target - nums[i] == 0) {
                add(path, res);
            } else if (target - nums[i] > 0) {
                process(nums, i, target - nums[i], path, res);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;

        System.out.println(combinationSum(nums, target));
    }
}
