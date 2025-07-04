class Solution {
    public char kthCharacter(int k) {
        StringBuilder res = new StringBuilder("a");

        while(res.length() < k){
            int size = res.length();
            for(int i=0; i<size; i++){
                res.append((char) ('a' + ((res.charAt(i) - 'a') + 1) % 26));
            }
        }
        return res.charAt(k-1);
    }
}