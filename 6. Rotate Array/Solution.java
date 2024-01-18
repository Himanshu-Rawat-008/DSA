class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int l = k%n;

        for(int i=0;i<n/2;i++) {
            int index = n-i-1;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

        for (int i=0;i<l/2;i++) {
            int index = l-i-1;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    
        for(int i=l;i<(n+l)/2;i++) {
            int index = n+l-i-1; 
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

    }
}