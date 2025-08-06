class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar=prices[0], max=0;

        for(int num : prices){
            if(num < minSoFar){
                minSoFar = num;
            }else{
                max = Math.max(max,num - minSoFar);
            }        
        }
        return max;
    }
}