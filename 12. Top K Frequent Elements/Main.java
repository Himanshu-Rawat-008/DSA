import java.util.*;;

class Pair {
    int key;
    int value;

    public Pair(int _key, int _value) {
        this.key = _key;
        this.value = _value;
    }
}

public class Main {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.value > p2.value || p1.value == p2.value && p1.key > p2.key) {
                    return 1;
                }
                return -1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry entry : hm.entrySet()) {
            pq.offer(new Pair((int) entry.getKey(), (int) entry.getValue()));
            if (pq.size() > k)
                pq.poll();
        }

        int ind = 0;
        while (!pq.isEmpty()) {
            ans[ind++] = pq.poll().key;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] res = topKFrequent(arr, k);

        for (int i = 0; i < k; i++)
            System.out.println(res[i]);
    }
}
