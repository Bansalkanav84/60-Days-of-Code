class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] ar = new int[2];

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                ar[0] = mp.get(target - nums[i]);
                ar[1] = i;
                return ar;
            }
            mp.put(nums[i],i);
        }
        return ar;
    }
}