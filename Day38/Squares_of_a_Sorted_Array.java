class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i=0, j=nums.length-1;

        for(int p=j; p>=0; p--){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                res[p] = nums[i]*nums[i];
                i++;
            }
            else{
                res[p] = nums[j]*nums[j];
                j--;
            }
        }
        return res;
    }
}