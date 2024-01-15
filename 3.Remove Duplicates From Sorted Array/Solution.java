class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int i = 0;

        while(i<nums.length) {
            if(nums[index-1]<nums[i]) {
                nums[index] = nums[i];
                index++;
            }
            i++;
        }
        return index;
    }
}