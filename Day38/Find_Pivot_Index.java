class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int rightsum=0, leftsum=0;

        for(int num : nums){
            rightsum += num;
        }

        for(int i=0; i<n; i++){
            rightsum -= nums[i];
            if(leftsum == rightsum) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}