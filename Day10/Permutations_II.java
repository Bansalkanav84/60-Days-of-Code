class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        find(used,res,new ArrayList<>(),nums);
        return res;
    }

    private void find(boolean used[], List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){   // we find a permutation so add it to result
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                
            temp.add(nums[i]);    // add the curr element (Take condition)
            used[i] = true;
            find(used,res,temp,nums);  // recurse to find permutations with the current temp
            temp.remove(temp.size()-1); // remove the last element (Not Take condition)
            used[i] = false;
        }
    }
}