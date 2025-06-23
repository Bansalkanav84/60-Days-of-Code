class Solution {
    public int pivotIndex(int[] nums) {
        int[] ps = new int[nums.length];
        int n=nums.length;
        
        ps[0] = nums[0];
        for(int i=1; i<n; i++){    
            ps[i] = nums[i] + ps[i-1];
        }
        int left_sum;
        int right_sum;

        for(int i =0;i<n;i++){
            if(i==0){
                left_sum=0;
            }
            else{
                left_sum=ps[i-1];
            }

            if(i==n-1){
                right_sum=0;
            }
            else{
                right_sum = ps[n-1] - ps[i];
            }

            if(left_sum==right_sum){
                return i;
            }
        }

        return -1;
    }
}