import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int ans = 0;

        for(int i = 0; i<n; i++) {
            if(ans == 0 && citations[i] > 0) {
                ans = 1;
            }
            if(citations[i] > 0) {
                int rem = n - i;
                if(rem > ans && citations[i] >= rem) {
                    ans = rem;
                }
            }
        }
        return ans;
    }
}