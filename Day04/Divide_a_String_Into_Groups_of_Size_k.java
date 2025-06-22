class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = (int)Math.ceil((double)s.length()/k);
        String[] res = new String[n];

        StringBuilder str = new StringBuilder();
        int i=0, val=k, j=0;
        while(i<s.length()){
            if(val>0){
                str.append(s.charAt(i));
                i++;
                val--;
            }
            if(str.length() == k){
                res[j] = str.toString();
                j++;
                str = new StringBuilder();
                val=k;
            }
        }

        if(str.length()>0){
            while(str.length()<k){
                str.append(fill);
            }
            res[j] = str.toString();
        }
        
        return res;
    }
}