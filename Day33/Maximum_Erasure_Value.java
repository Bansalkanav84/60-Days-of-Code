class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int L=0, R=0, sum=0, max = 0;

        while(R < nums.length){
            while(set.contains(nums[R])){
                set.remove(nums[L]);
                sum -= nums[L];
                L++;
            }
            set.add(nums[R]);
            sum += nums[R];
            R++;
            
            max = Math.max(max,sum);
        }
        return max;
    }
}