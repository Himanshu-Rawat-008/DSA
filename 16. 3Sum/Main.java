import java.util.*;

public class Main {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            int s = i + 1;
            int e = N - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (s < e) {
                int total = nums[s] + nums[e] + nums[i];
                if (total < 0)
                    s++;
                else if (total > 0) {
                    e--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    res.add(temp);
                    while (s < e && nums[s] == temp.get(1))
                        s++;
                    while (s < e && nums[e] == temp.get(2))
                        e--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                { -2, 0, 1, 1, 2 },
                { 0, 0, 0 },
                { 0, 1, 1 },
                { -1, 0, 1, 2, -1, -4 }
        };

        for (int i = 0; i < arr.length; i++)
            System.out.println(threeSum(arr[i]));
    }
}
