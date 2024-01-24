import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int res[] = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        
        for(int i=0;i<n;i++) {
            
            for (int j = i+1; j<n && j<=nums[i]+i; j++) {
                
                res[j] = Math.min(res[j], res[i]+1);
            }
        }
        
        return res[n-1];
    }
}