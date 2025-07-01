class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        find(1,k,n,res,new ArrayList<>());  // Call the helper func.
        return res;
    }

    private static void find(int start,int k,int target,List<List<Integer>> res,List<Integer> temp){
        if(target < 0) return;        // if target becomes less than 0, no need of continuing
        
        if(temp.size() == k){         // Found a valid combination 
            if(target == 0){          // If it's target is 0 i.e the elements add upto n  
                res.add(new ArrayList<>(temp));  // Add to result 
                return;
            }
        }

        for(int i=start; i<=9; i++){  // Since we can have nums from 1 to 9
            temp.add(i);              // TAKE CONDITION 
            find(i+1,k,target-i,res,temp); // Recurse
            temp.remove(temp.size()-1); // NOT TAKE CONDITION 
        }
    }
}