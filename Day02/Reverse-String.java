class Solution {
    public void reverseString(char[] s) {
        int i=0, j=s.length-1; // Initialize i to start and j to end
        char temp = s[i]; 
        while(i<j){
            temp = s[i];  // In place Swap
            s[i] = s[j];
            s[j] = temp; 
            i++;         // move the pointers
            j--;
        }
    }
}