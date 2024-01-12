class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // at this index number should be equal to val
        int j = 0; // at this index find numbers not equal to val

        while(j< nums.length) {
            if(nums[i] != val && nums[j] != val) {
                i++;
                j++;
            } else if(nums[i] == val && nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } 
            else if(nums[i] == val) {
                j++;
            }
        }

        return i;
    }
}