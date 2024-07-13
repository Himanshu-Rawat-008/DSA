public class Main {

    public static String formatString(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            int curr = (int) s.charAt(i);
            if (65 <= curr && curr <= 90) {
                r = r + (char) (curr + 32);
            } else if (97 <= curr && curr <= 122) {
                r = r + s.charAt(i);
            } else if (48 <= curr && curr <= 57)
                r = r + s.charAt(i);
        }

        return r;
    }

    public static boolean checkPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        String r = formatString(s);

        return checkPalindrome(r);
    }

    public static void main(String[] args) {
        String s[] = { "0P", "121", "race a car", "A man, a plan, a canal: Panama" };
        Boolean result[] = { false, true, false, true };

        for (int i = 0; i < s.length; i++) {

            if (isPalindrome(s[i]) != result[i]) {
                System.out.println("Failed Test Case");
            } else {
                System.out.println("Passed");
            }
        }
    }
}
