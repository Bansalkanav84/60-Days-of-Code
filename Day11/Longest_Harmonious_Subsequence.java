class Solution {
    public int findLHS(int[] nums) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);

        int i=0, j=1, res=0;
        while(j<nums.length){
            if(nums[j]-nums[i] == 1){
                res = Math.max(res,j-i+1);
                j++;
            }
            else if(nums[j]-nums[i] > 1){
                i++;
            }
            else{
                j++;
            }
        }
        return res;
    }
}