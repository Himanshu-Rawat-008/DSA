import java.util.*;

public class Main {
    public static String getKey(int dig) {
        String res = "";
        switch (dig) {
            case 2: {
                res = "abc";
                break;
            }
            case 3: {
                res = "def";
                break;
            }
            case 4: {
                res = "ghi";
                break;
            }
            case 5: {
                res = "jkl";
                break;
            }
            case 6: {
                res = "mno";
                break;
            }
            case 7: {
                res = "pqrs";
                break;
            }
            case 8: {
                res = "tuv";
                break;
            }
            case 9: {
                res = "wxyz";
                break;
            }
            default: {
                res = "";
                break;
            }
        }

        return res;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        process(digits, res, 0, "");
        return res;
    }

    public static void process(String digits, List<String> res, int currIndex, String path) {

        if (digits.length() == currIndex) {
            res.add(path);
            return;
        }
        int dig = Character.getNumericValue(digits.charAt(currIndex));
        String s = getKey(dig);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            process(digits, res, currIndex + 1, path + String.valueOf(c));
        }
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }
}
