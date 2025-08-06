class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0, i;
        for(i=0; i<nums.length-1; i++){
            while(nums[i] == nums[j] && j<nums.length-1) j++;
            nums[i+1] = nums[j];
            if(nums[i] == nums[i+1]) break;
        }
        return i+1;
    }
}