class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
			return intervals;
    
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] curr = intervals[0];
        ans.add(curr);

        for(int i=1; i<intervals.length; i++){
            int[] next = intervals[i];

            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1],next[1]);
            }
            else{
                curr = next;
                ans.add(curr);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}