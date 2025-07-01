class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // Sorting to help us avoid duplicates
        find(res, nums, new ArrayList<>(),0);  // call the helper
        return res;
    }

    private static void find(List<List<Integer>> res, int[] nums, List<Integer> temp, int start){
        res.add(new ArrayList<>(temp));  // add temp to result 

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue; // Skip Duplicates
            temp.add(nums[i]);          // TAKE CONDITION
            find(res,nums,temp,i+1);    // Recurse
            temp.remove(temp.size()-1); // NOT TAKE CONDITION
        }
    }
}