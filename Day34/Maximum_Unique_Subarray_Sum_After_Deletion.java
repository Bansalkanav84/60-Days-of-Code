class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;


        for(int num : nums){
            if(!set.contains(num) && num > 0) {
                sum += num;
            }
            else if(num <= 0){
                max = Math.max(max,num);
            }
            set.add(num);
        }
        if(sum > 0) return sum;
        return max;
    }
}