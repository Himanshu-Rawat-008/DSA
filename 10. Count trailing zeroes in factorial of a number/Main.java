public class Main {
    public static int trailingZeroes(int n) {
        int count = 0;
        int i = 5;

        // Count trailing zeroes by dividing by increasing powers of 5
        while (n / i > 0) {
            count += n / i;
            i *= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }
}
