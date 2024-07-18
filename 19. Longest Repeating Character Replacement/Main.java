public class Main {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String str, int k) {
        int arr[] = new int[26];
        int N = str.length();
        int res = 0;
        int s = 0; // starting
        int e = 0; // ending
        while (e < N) {
            arr[str.charAt(e) - 65]++;
            e++;

            int diff = 0; // difference
            int max_freq = 0; // max_frequency
            for (int i = 0; i < 26; i++) {
                if (max_freq < arr[i]) {
                    diff += max_freq;
                    max_freq = arr[i];
                } else
                    diff += arr[i];
            }

            if (diff > k) {
                // if difference > k, subtract frequency of character
                arr[str.charAt(s) - 65]--;
                s++;
            } else if (diff <= k) {
                // if difference <= k, valid condition so store result
                res = Math.max(res, max_freq + diff);
            }
        }
        return res;
    }
}
