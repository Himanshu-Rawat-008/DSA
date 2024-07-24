public class Main {
    public static int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            max = Math.max(max, piles[i]);

        int s = 1;
        int e = max;
        int res = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = (s + e) / 2;
            int ans = 0;
            for (int p = 0; p < piles.length; p++) {
                if (piles[p] <= mid)
                    ans++;
                else if (piles[p] > mid) {
                    ans = ans + (piles[p] / mid);
                    if (piles[p] % mid > 0)
                        ans++;
                }

            }

            if (ans <= h && ans > 0) {
                res = Math.min(res, mid);
            }

            if (ans <= h)
                e = mid - 1;
            else
                s = mid + 1;

        }

        return res;
    }

    public static void main(String[] args) {
        int[] piles = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles, h));
    }
}
