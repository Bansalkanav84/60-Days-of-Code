class Solution {
    public int possibleStringCount(String word) {
        int count = 1;   
        for(int i=0; i<word.length(); i++){            
            while(i<word.length()-1 && word.charAt(i) == word.charAt(i+1)){
                count++;
                i++;
            }
        }
        return count;
    }
}