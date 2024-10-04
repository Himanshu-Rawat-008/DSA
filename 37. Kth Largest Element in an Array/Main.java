import java.util.*;;

public class Main {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int num : nums)
            pq.add(num);

        while (nums.length - pq.size() + 1 < k)
            pq.poll();

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
