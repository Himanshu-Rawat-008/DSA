import java.util.*;

public class Main {
    public static List<List<Integer>> res;
    public static Set<List<Integer>> keys;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        keys = new HashSet<>();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            arr.add(nums[i]);

        process(arr);
        res.add(new ArrayList<>());
        return res;
    }

    public static void process(List<Integer> arr) {
        if (arr.size() == 0)
            return;
        if (!keys.contains(arr)) {
            res.add(new ArrayList<>(arr));
            keys.add(new ArrayList<>(arr));
        }

        if (arr.size() == 1)
            return;

        for (int i = 0; i < arr.size(); i++) {
            int element = arr.remove(i);
            if (arr.size() != 0) {
                process(arr);
            }

            arr.add(i, element);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        System.out.println(subsets(nums));
    }
}
