public class Main {
    public static int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (target == numbers[i] + numbers[j])
                    return new int[] { i + 1, j + 1 };

        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
