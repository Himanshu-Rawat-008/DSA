public class Main {

    static int solution(int[] arr, int N) {
        int x1 = 1;

        for (int i = 2; i <= N + 1; i++)
            x1 = x1 ^ i;

        int x2 = arr[0];

        for (int i = 1; i < N; i++) {
            x2 = x2 ^ arr[i];
        }

        return x1 ^ x2;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5 };
        int N = arr.length;

        int result = solution(arr, N);
        System.out.println(result);
    }
}