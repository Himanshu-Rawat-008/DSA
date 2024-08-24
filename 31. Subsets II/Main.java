import java.util.*;

public class Main {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, set, new ArrayList<>());
        for (List<Integer> a : set)
            res.add(a);
        return res;
    }

    public static void process(int[] nums, int start, Set<List<Integer>> set, List<Integer> path) {
        set.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            process(nums, i + 1, set, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));
    }
}
