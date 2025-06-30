class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(res,new ArrayList<>(),nums); // call the helper
        return res;
    }

    private void find(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){   // we find a permutation so add it to result
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(temp.contains(nums[i])) continue;  // skip if we have already added that element 

            temp.add(nums[i]);    // add the curr element (Take condition)
            find(res,temp,nums);  // recurse to find permutations with the current temp
            temp.remove(temp.size()-1); // remove the last element (Not Take condition) 
        }
    }
}