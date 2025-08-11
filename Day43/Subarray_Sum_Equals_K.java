class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0, res=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);

        for(int num : nums){
            sum += num;

            if(mp.containsKey(sum - k)){
                res += mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return res;
    }
}