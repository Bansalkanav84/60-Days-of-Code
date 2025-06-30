class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        int[] copy = nums.clone();
        Arrays.sort(copy);        // Make a copy of nums and sort it

        for(int i=n-1; i>=n-k; i--){
            mp.put(copy[i],mp.getOrDefault(copy[i],0)+1); // populate hashmap with top k element and it's freq
        }
        
        int[] res = new int[k];
        int j=0;
        for(int num : nums){  // for every num see if it exists in hashmap
            int count = mp.getOrDefault(num,0);
            if(count > 0){     // if yes , store in res and decrease it's freq
                res[j++] =num;
                mp.put(num,count-1);
            }  
            if(j==k) break;  // fill only k elements
        }
        return res;
    }
}