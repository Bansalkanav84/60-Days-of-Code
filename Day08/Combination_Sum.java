class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        find(0,candidates,target,res,new ArrayList<>());
        return res;
    }

    private static void find(int idx,int[] nums,int target,List<List<Integer>> res,List<Integer> ds){
        if(target < 0) return;

        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            ds.add(nums[i]);
            find(i,nums,target-nums[i],res,ds);
            ds.remove(ds.size()-1);
        }

    }
}