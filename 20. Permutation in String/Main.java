public class Main {

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] diff = new int[26];
        int difference = 0;
        for (int i = 0; i < len1; i++) {
            diff[s1.charAt(i) - 97]++;
            diff[s2.charAt(i) - 97]--;

        }
        for (int d : diff) {
            if (d > 0) {
                difference++;
            }
        }
        if (difference == 0) {
            return true;
        }

        for (int i = 0; i < len2 - len1; i++) {
            if (++diff[s2.charAt(i) - 97] == 1) {
                difference++;
            }
            if (--diff[s2.charAt(i + len1) - 97] == 0) {
                difference--;
            }
            if (difference == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1[] = {
                "ccc",
                "hello",
                "adc",
                "abc"
        };

        String s2[] = {
                "cbac",
                "ooolleoooleh",
                "dcda",
                "cdcba"
        };

        for (int i = 0; i < s1.length; i++)
            System.out.println(checkInclusion(s1[i], s2[i]));
    }

}
