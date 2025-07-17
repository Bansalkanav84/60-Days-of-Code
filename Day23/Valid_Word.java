class Solution {
    public boolean isValid(String word) {
        String VOWELS = "aeiouAEIOU";

        if(word.length() < 3) return false;
        
        int vow = 0, cons = 0;
        for(char c : word.toCharArray()){
            if(Character.isDigit(c)) continue;

            if(Character.isLetter(c)){
                if(VOWELS.indexOf(c) >= 0) vow++;
                else cons++;
            }
            else{
                return false;
            }
        }
        return vow>0 && cons>0;
    }
}
