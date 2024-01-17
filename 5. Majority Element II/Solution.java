class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list=new ArrayList<Integer>();
        int step = nums.length/3;
        
        for(int i =0;i<nums.length - step && list.size() < 2; i++) {

            if(nums[i] == nums[i + step]) {
                if(list.size() == 0 || list.get(0) != nums[i])
                list.add(nums[i]);
            }

        }
    return list;
    }
}
