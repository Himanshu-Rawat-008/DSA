class Solution {
    public boolean canJump(int[] nums) {
       int maxIndex = 0;

       for(int i=0; i < nums.length && maxIndex >= i; i++) {
           if(i + nums[i] > maxIndex) {
               maxIndex = i+nums[i];
           }
       }
       return maxIndex >= nums.length-1;
    }
}