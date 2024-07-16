import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int N = s.length();
        int res = 0, l = 0, r = 0;
        int[] arr = new int[256];
        Arrays.fill(arr, -1);
        while (r < s.length()) {
            if (l <= arr[s.charAt(r)]) {
                l = arr[s.charAt(r)] + 1;
            } else {
                arr[s.charAt(r)] = r;
                res = Math.max(res, r - l + 1);
                r++;
            }
        }
        return res;
    }
}
