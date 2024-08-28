import java.util.*;

public class Main {
    static List<List<String>> res;

    static public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        process(s, curr, 0, s.length());
        return res;
    }

    static public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;

        return true;
    }

    public static void process(String s, List<String> curr, int currIndex, int N) {
        boolean isLastPalindrome = curr.size() == 0 || isPalindrome(curr.get(curr.size() - 1));
        if (!isLastPalindrome)
            return;
        if (s.length() == currIndex) {
            if (isLastPalindrome) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = currIndex; i < s.length(); i++) {
            String s1 = s.substring(currIndex, i + 1);
            // System.out.println(s1+" "+currIndex);
            curr.add(s1);
            process(s, curr, i + 1, N);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
