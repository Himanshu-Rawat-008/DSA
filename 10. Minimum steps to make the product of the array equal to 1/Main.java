public class Main {

    public static int MinStep(int[] a, int n) {

        int positive = 0, negative = 0, zero = 0;

        int step = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zero++;
            } else if (a[i] < 0) {
                negative++;
                step = step + (-1 - a[i]);
            } else {
                positive++;
                step = step + (a[i] - 1);
            }
        }
        if (negative % 2 == 0) {
            step = step + zero;
        } else {
            if (zero > 0) {
                step = step + zero;
            } else {
                step = step + 2;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        int a[] = { 0, -2, -1, -3, 4 };
        int n = a.length;

        System.out.println(MinStep(a, n));
    }
}
