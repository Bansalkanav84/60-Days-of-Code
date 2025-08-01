class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if(digits[n-1] != 9){
            digits[n-1]++;
        }
        else{
            int i = 1;
            while(i<= n && digits[n-i] == 9){
                digits[n-i] = 0;
                i++;
            }
            if(i > n){
                int[] arr = new int[n+1];
                arr[0] = 1;
                return arr;
            }else{
                digits[n-i]++;
            }
            
        }
        return digits;
    }
}