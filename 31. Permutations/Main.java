import java.util.*;;

public class Main {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        for (int i : nums)
            arr.add(i);
        process(arr, res, new ArrayList<>());
        return res;
    }

    public static void process(List<Integer> arr, List<List<Integer>> res, List<Integer> path) {
        if (arr.size() == 0)
            res.add(new ArrayList<>(path));

        for (int i = 0; i < arr.size(); i++) {
            int curr = arr.remove(i);
            path.add(curr);
            process(arr, res, path);
            arr.add(i, curr);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
