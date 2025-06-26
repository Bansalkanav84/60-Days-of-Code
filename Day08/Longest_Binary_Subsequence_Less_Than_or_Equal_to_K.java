class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        long pow = 1;
        long value = 0;

        for(char c: s.toCharArray()){
            if(c == '0') zeros++;
        }

        for(int i=n-1; i>=0; i--){
            if(pow > k) break;
            if(s.charAt(i) == '1'){
                if(value+pow > k) break;
                value+=pow;
                ones++;
            } 
            pow*=2;                        
        }
        return zeros+ones;
    }
}