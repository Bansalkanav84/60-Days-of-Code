class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);   // Sorting helps us skip duplicate combinations
        find(0,candidates,target,res,new ArrayList<>());
        return res;
    }

    private static void find(int idx,int[] arr, int target, List<List<Integer>> res, List<Integer> temp){
        
        if(target == 0){        // Basically we are subtracting from target, so when target ==0, we found an combination 
            res.add(new ArrayList<>(temp)); // add that combination to result
            return;
        }

        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i] == arr[i-1]) continue;  // skip duplicates, since arr is sorted duplicates will be adjacent
            if(arr[i] > target) break;  // target - arr[i] would become negative, thus no need to proceed further

            temp.add(arr[i]);       // TAKE CASE
            find(i+1,arr,target-arr[i],res,temp); // move to next index and update target
            temp.remove(temp.size()-1); // NOT TAKE CASE
        }
    }
}