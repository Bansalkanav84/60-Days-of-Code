class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans=0;

        for(int fruit : fruits){
            for(int i=0; i<baskets.length; i++){
                if(baskets[i] >= fruit){
                    baskets[i] = -1;
                    ans++;
                    break;
                }
            }
        }

        return fruits.length - ans;
    }
}