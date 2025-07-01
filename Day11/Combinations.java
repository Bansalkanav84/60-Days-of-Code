class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        find(1,n,k,res,new ArrayList<>());
        return res;
    }

    private static void find(int start, int n, int k, List<List<Integer>> res, List<Integer> temp){
        if(temp.size() == k){     // Found a valid combination 
            res.add(new ArrayList<>(temp));   // add it to result
            return;
        }

        for(int i=start; i<=n; i++){
            temp.add(i);               // TAKE CONDITION
            find(i+1,n,k,res,temp);    // Recurse
            temp.remove(temp.size()-1);// NOT TAKE CONDITION 
        }
    }
}