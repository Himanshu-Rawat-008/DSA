import java.util.*;

public class Main {
    public static int longestConsecutive(int[] nums) {
        int N = nums.length;

        Set<Integer> s = new HashSet<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        for (int curr : nums)
            s.add(curr);

        // for(int curr: map.keySet())
        // arr.add(curr);

        int maxLength = 0;
        for (int curr : s) {
            int max = 0;
            int temp = curr;
            if (!s.contains(temp - 1)) {
                while (s.contains(temp)) {
                    max++;
                    temp++;
                }
            }
            maxLength = Math.max(max, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums));
    }
}