class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] a1 = new int[256];
        int[] a2 = new int[256];

        for(int i=0; i<s.length(); i++){

            if(a1[s.charAt(i)]!=a2[t.charAt(i)]){
                return false;
            }
            a1[s.charAt(i)] = i+1;
            a2[t.charAt(i)] = i+1;
        }
        return true;
    }
}