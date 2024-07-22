import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        System.out.println(minWindow(s1, s2));
    }

    public static String minWindow(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        String res = "";
        if (len2 > len1) {
            return "";
        }
        int[] diff = new int[256];
        int difference = 0;
        Arrays.fill(diff, Integer.MIN_VALUE);
        for (int i = 0; i < len2; i++) {
            if (diff[s2.charAt(i)] == Integer.MIN_VALUE) {
                diff[s2.charAt(i)] = 0;
                diff[s2.charAt(i)]++;
            } else {
                diff[s2.charAt(i)]++;
            }
        }
        int start = 0;
        int end = 0;

        while (end < len1) {
            int index = s1.charAt(end);
            if (diff[index] != Integer.MIN_VALUE) {
                diff[index]--;
            }
            while (diff[s1.charAt(start)] < 0 && start < end) {
                if (diff[s1.charAt(start)] != Integer.MIN_VALUE) {
                    diff[s1.charAt(start)]++;
                }
                start++;
            }
            end++;

            boolean flag = true;
            for (int i = 0; i < 256; i++) {
                if (diff[i] != Integer.MIN_VALUE && diff[i] > 0)
                    flag = false;
            }
            String t = s1.substring(start, end);

            if (flag)
                res = res.length() != 0 && res.length() < t.length() ? res : t;
        }

        return res;
    }
}
