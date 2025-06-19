// 20th Junes's POTD

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);       // Sort the Array

        int max = nums[0]+k;  // The max value we can have in a partition starting from first element 
        int count=1;          
        for(int i=1; i<nums.length; i++){
            if(nums[i] <= max) continue;  // if me can accommodate the curr element in a partition then continue 
            count++;   // else make a partition 
            max = nums[i]+k; // update the max according to the start of the new partition
        }
        return count; // return the no. of partitions
    }
}