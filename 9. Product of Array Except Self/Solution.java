class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int[] res = new int[n];

        for(int i = n-1;i>-1;i--) {
            int suffix = i+1 < n ? res[i+1] : 1;
            res[i] = suffix * nums[i]; 
        }

        for(int i=0;i<n;i++) {
            int curr = prefix;
            prefix = prefix * nums[i];
            int suffix = i+1 == n ? 1 : res[i+1];
            res[i] = curr * suffix;
        }

        return res;
    }
}